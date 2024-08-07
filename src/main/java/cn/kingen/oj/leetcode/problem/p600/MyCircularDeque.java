package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-circular-deque/">641. Design Circular Deque</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.MyCircularQueue
 * @see cn.kingen.oj.leetcode.problem.p1600.FrontMiddleBackQueue
 */
@Question(
        tags = {Tag.DESIGN, Tag.QUEUE, Tag.ARRAY, Tag.LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class MyCircularDeque {

    private final int capacity;
    private final int[] arr;
    private int size;
    private int start;

    @Complexity(time = "O(1)", space = "O(k)")
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.arr = new int[k];
        this.size = 0;
        this.start = 0;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }
        start = (start + capacity - 1) % capacity;
        arr[start] = value;
        size++;
        return true;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        arr[(start + size) % capacity] = value;
        size++;
        return true;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        size--;
        start = (start + 1) % capacity;
        return true;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        size--;
        return true;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int getFront() {
        return size == 0 ? -1 : arr[start];
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int getRear() {
        return size == 0 ? -1 : arr[(start + size - 1) % capacity];
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean isEmpty() {
        return size == 0;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean isFull() {
        return size == capacity;
    }
}