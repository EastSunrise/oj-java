package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-skiplist/">1206. Design Skiplist</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.MyHashSet
 * @see cn.kingen.oj.leetcode.problem.p700.MyHashMap
 * @see cn.kingen.oj.leetcode.problem.p700.MyLinkedList
 */
@Question(
        tags = {Tag.DESIGN, Tag.LINKED_LIST},
        difficulty = Difficulty.HARD
)
public class Skiplist {

    private static final int MAX_LEVEL = 16;
    private Node head;
    private int levelSize;

    @Complexity(time = "O(1)", space = "O(n)")
    public Skiplist() {
        this.head = new Node(-1, null);
        this.levelSize = 1;
    }

    @Complexity(time = "O(log{n})", space = "O(1)")
    public boolean search(int key) {
        Node p = head;
        while (p != null) {
            while (p.next != null && p.next.key < key) {
                p = p.next;
            }
            if (p.next != null && p.next.key == key) { // key is found
                return true;
            }
            p = p.down;
        }
        return false;
    }

    @Complexity(time = "O(log{n})", space = "O(1)")
    public void add(int key) {
        int level = randomLevel();
        while (levelSize < level) { // extend levels
            head = new Node(-1, null, head);
            levelSize++;
        }
        Node p = head, up = null;
        for (int i = levelSize - 1; i >= 0; i--) {
            while (p.next != null && p.next.key < key) {
                p = p.next;
            }
            if (i < level) { // insert a node at current level
                p.next = new Node(key, p.next);
                if (up != null) {
                    up.down = p.next;
                }
                up = p.next;
            }
            p = p.down;
        }
    }

    /**
     * Uses random number to decide the level of the node.
     */
    private int randomLevel() {
        int level = 1;
        while (level < MAX_LEVEL && Math.random() < 0.5f) {
            level++;
        }
        return level;
    }

    @Complexity(time = "O(log{n})", space = "O(1)")
    public boolean erase(int key) {
        boolean found = false;
        Node p = head;
        while (p != null) {
            while (p.next != null && p.next.key < key) {
                p = p.next;
            }
            if (p.next != null && p.next.key == key) { // key is found
                p.next = p.next.next;
                found = true;
            }
            p = p.down;
        }
        return found;
    }

    static class Node {

        int key;
        Node next;
        Node down;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }

        public Node(int key, Node next, Node down) {
            this.key = key;
            this.next = next;
            this.down = down;
        }
    }
}