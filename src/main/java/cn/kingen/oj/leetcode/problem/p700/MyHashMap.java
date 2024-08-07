package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-hashmap/">706. Design HashMap</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.MyHashSet
 * @see cn.kingen.oj.leetcode.problem.p1200.Skiplist
 * @see cn.kingen.oj.leetcode.problem.p10000.ConsistentHashing
 */
@Question(tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.LINKED_LIST, Tag.HASH_FUNCTION}, difficulty = Difficulty.EASY)
public class MyHashMap {

    private Node[] table;
    private int size;
    private int threshold;

    @Complexity(time = "#", space = "O(n)")
    public MyHashMap() {
        this.table = new Node[16];
        this.size = 0;
        this.threshold = (int) (0.75f * table.length);
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void put(int key, int value) {
        int hash = hash(key), i = hash & (table.length - 1);
        Node p;
        if ((p = table[i]) == null) { // create a new node
            table[i] = new Node(hash, key, value, null);
        } else if (p.key == key) { // already exists
            p.value = value;
            return;
        } else {
            Node e;
            while ((e = p.next) != null && e.key != key) {
                p = e;
            }
            if (e != null) { // already exists
                e.value = value;
                return;
            } else { // add a node to the end
                p.next = new Node(hash, key, value, null);
            }
        }
        if (++size > threshold) {
            resize();
        }
    }

    private int hash(int key) {
        return key ^ (key >>> 10);
    }

    private void resize() {
        int oldCap = table.length, oldThr = threshold;
        int newCap = oldCap << 1;
        threshold = oldThr << 1;

        Node[] oldTab = table;
        Node[] newTab = new Node[newCap];
        table = newTab;

        for (int i = 0; i < oldCap; i++) {
            Node p = oldTab[i];
            if (p == null) {
                continue;
            }

            oldTab[i] = null;
            if (p.next == null) {
                newTab[p.hash & (newCap - 1)] = p;
            } else {
                Node lowHead = null, lowTail = null;
                Node highHead = null, highTail = null;
                do {
                    if ((p.hash & oldCap) == 0) {
                        if (lowTail == null) lowHead = p;
                        else lowTail.next = p;
                        lowTail = p;
                    } else {
                        if (highTail == null) {
                            highHead = p;
                        } else {
                            highTail.next = p;
                        }
                        highTail = p;
                    }
                    p = p.next;
                } while (p != null);

                if (lowTail != null) {
                    lowTail.next = null;
                    newTab[i] = lowHead;
                }
                if (highTail != null) {
                    highTail.next = null;
                    newTab[i + oldCap] = highHead;
                }
            }
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int get(int key) {
        int i = hash(key) & (table.length - 1);
        Node p = table[i];
        while (p != null && p.key != key) {
            p = p.next;
        }
        return p == null ? -1 : p.value;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void remove(int key) {
        int i = hash(key) & (table.length - 1);
        Node p = table[i];
        if (p == null) {
            return;
        }
        if (p.key == key) {
            table[i] = p.next;
            --size;
        } else {
            Node e;
            while ((e = p.next) != null && e.key != key) {
                p = e;
            }
            if (e != null) {
                p.next = e.next;
                --size;
            }
        }
    }

    private static class Node {

        private final int hash;
        private final int key;
        private int value;
        private Node next;

        Node(int hash, int key, int value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}