package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/moving-average-from-data-stream/">346. Moving Average from Data Stream</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2090
 */
@Question(
        paidOnly = true,
        tags = {Tag.DESIGN, Tag.QUEUE, Tag.ARRAY, Tag.DATA_STREAM},
        difficulty = Difficulty.EASY
)
public class MovingAverage {

    private final int[] window;
    private int offset = 0;
    private int sum = 0;
    private int count = 0;

    @Complexity(time = "O(1)", space = "O(n)", note = "n is the size of the window")
    public MovingAverage(int size) {
        this.window = new int[size];
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public double next(int val) {
        sum = sum + val - window[offset];
        count++;
        window[offset++] = val;
        if (offset >= window.length) {
            offset = 0;
        }
        return (double) sum / Math.min(count, window.length);
    }
}