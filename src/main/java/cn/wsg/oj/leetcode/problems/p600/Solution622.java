package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1600.Solution1670;

/**
 * 622. Design Circular Queue (MEDIUM)
 *
 * @author Kingen
 * @see Solution641
 * @see Solution1670
 * @see <a href="https://leetcode-cn.com/problems/design-circular-queue/">Design Circular Queue</a>
 */
public class Solution622 implements Solution {

    static class MyCircularQueue {

        private final int capacity;
        private final int[] arr;
        private int size;
        private int start;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.arr = new int[k];
            this.size = 0;
            this.start = 0;
        }

        public boolean enQueue(int value) {
            if (size == capacity) {
                return false;
            }
            arr[(start + size) % capacity] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            start = (start + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            return size == 0 ? -1 : arr[start];
        }

        public int Rear() {
            return size == 0 ? -1 : arr[(start + size - 1) % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
