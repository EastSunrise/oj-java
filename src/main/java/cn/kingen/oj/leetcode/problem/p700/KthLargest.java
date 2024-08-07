package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-a-stream/">703. Kth Largest Element in a Stream</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution215
 */
@Question(
        tags = {Tag.TREE, Tag.DESIGN, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE, Tag.DATA_STREAM, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.EASY
)
public class KthLargest {

    private final int k;
    private final Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.remove();
        }
        return queue.element();
    }
}