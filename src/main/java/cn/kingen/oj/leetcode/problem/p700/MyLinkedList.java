package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-linked-list/">707. Design Linked List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Skiplist
 */
@Question(
        tags = {Tag.DESIGN, Tag.LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class MyLinkedList {

    int size = 0;
    Node head, tail;

    public MyLinkedList() {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * @return the value of the index-th node in the linked list, or -1 if the index is invalid
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return nodeAt(index).val;
    }

    private Node nodeAt(int index) {
        Node t;
        if (index < size / 2) {
            t = head.next;
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
        } else {
            t = tail.prev;
            for (int i = size - 1; i > index; i--) {
                t = t.prev;
            }
        }
        return t;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void addAtHead(int val) {
        insert(head, head.next, val);
    }

    private void insert(Node prev, Node next, int val) {
        Node newNode = new Node(val, prev, next);
        prev.next = newNode;
        next.prev = newNode;
        size++;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void addAtTail(int val) {
        insert(tail.prev, tail, val);
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            insert(head, head.next, val);
        } else if (index < size) {
            Node t = nodeAt(index);
            insert(t.prev, t, val);
        } else if (index == size) {
            insert(tail.prev, tail, val);
        }
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node node = nodeAt(index);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
    }

    static class Node {

        final int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}