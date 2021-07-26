package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 641. Design Circular Deque (MEDIUM)
 *
 * @author Kingen
 * @see Solution622
 * @see Solution1670
 * @see <a href="https://leetcode-cn.com/problems/design-circular-deque/">Design Circular Deque</a>
 * @since 2021-07-23
 */
public class Solution641 implements Solution {

    static class MyCircularDeque {

        private final int capacity;
        private final int[] arr;
        private int size;
        private int start;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.capacity = k;
            this.arr = new int[k];
            this.size = 0;
            this.start = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (size == capacity) {
                return false;
            }
            start = (start + capacity - 1) % capacity;
            arr[start] = value;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (size == capacity) {
                return false;
            }
            arr[(start + size) % capacity] = value;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            start = (start + 1) % capacity;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return size == 0 ? -1 : arr[start];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return size == 0 ? -1 : arr[(start + size - 1) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }
    }
}
