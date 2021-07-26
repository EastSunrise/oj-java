package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 707. Design Linked List (MEDIUM)
 *
 * @author Kingen
 * @see Solution1206
 * @see <a href="https://leetcode-cn.com/problems/design-linked-list/">Design Linked List</a>
 * @since 2021-07-26
 */
public class Solution707 implements Solution {

    static class MyLinkedList {

        int size = 0;
        DoublyNode first;
        DoublyNode last;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.first = new DoublyNode(-1, null, null);
            this.last = new DoublyNode(-1, null, null);
            first.next = last;
            last.prev = first;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return
         * -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return node(index).val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion,
         * the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addBetween(first, first.next, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addBetween(last.prev, last, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to
         * the length of linked list, the node will be appended to the end of linked list. If index
         * is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addBetween(first, first.next, val);
            } else if (index < size) {
                DoublyNode node = node(index);
                addBetween(node.prev, node, val);
            } else if (index == size) {
                addBetween(last.prev, last, val);
            }
        }

        private void addBetween(DoublyNode prev, DoublyNode next, int val) {
            DoublyNode newNode = new DoublyNode(val, prev, next);
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                DoublyNode node = node(index);
                node.next.prev = node.prev;
                node.prev.next = node.next;
                size--;
            }
        }

        private DoublyNode node(int index) {
            DoublyNode node;
            if (index < size / 2) {
                node = first.next;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
            } else {
                node = last.prev;
                for (int i = size - 1; i > index; i--) {
                    node = node.prev;
                }
            }
            return node;
        }

        private static class DoublyNode {

            int val;
            DoublyNode prev;
            DoublyNode next;

            DoublyNode(int val, DoublyNode prev, DoublyNode next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }

            @Override
            public String toString() {
                return next == null ? val + "" : val + "," + next;
            }
        }
    }
}
