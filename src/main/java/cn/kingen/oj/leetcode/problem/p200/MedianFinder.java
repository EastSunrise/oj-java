package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-median-from-data-stream/">295. Find Median from Data Stream</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution480
 * @see cn.kingen.oj.leetcode.problem.p1800.MKAverage
 * @see cn.kingen.oj.leetcode.problem.p2100.SORTracker
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3107
 */
@Question(
        tags = {Tag.DESIGN, Tag.TWO_POINTERS, Tag.DATA_STREAM, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class MedianFinder {

    /**
     * the maximum heap of the left half of sorted data.
     */
    PriorityQueue<Integer> left;
    /**
     * the minimum heap of the right half of sorted data.
     */
    PriorityQueue<Integer> right;

    @Complexity(time = "O(1)", space = "O(n)")
    public MedianFinder() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>();
    }

    @Complexity(time = "O(log n)", space = "O(1)")
    public void addNum(int num) {
        // 0 <= left.size() - right.size() <= 1
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
            if (left.size() - right.size() > 1) {
                right.offer(left.poll());
            }
        } else {
            right.offer(num);
            if (left.size() < right.size()) {
                left.offer(right.poll());
            }
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.element();
        }
        return (left.element() + right.element()) / 2.0;
    }
}