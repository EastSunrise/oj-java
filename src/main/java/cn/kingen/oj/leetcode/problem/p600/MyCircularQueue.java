package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-circular-queue/">622. Design Circular Queue</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.MyCircularDeque
 * @see cn.kingen.oj.leetcode.problem.p1600.FrontMiddleBackQueue
 */
@Question(
        tags = {Tag.DESIGN, Tag.QUEUE, Tag.ARRAY, Tag.LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class MyCircularQueue {

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

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean enQueue(int value) {
        if (size == capacity) {
            return false;
        }
        arr[(start + size) % capacity] = value;
        size++;
        return true;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        start = (start + 1) % capacity;
        size--;
        return true;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int Front() {
        return size == 0 ? -1 : arr[start];
    }

    @Complexity(time = "O(1)", space = "O(1)")
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