package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/">739. Daily Temperatures</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution496
 * @see cn.kingen.oj.leetcode.problem.p900.StockSpanner
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Solution739 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                ans[indices.peek()] = i - indices.pop();
            }
            indices.push(i);
        }
        return ans;
    }
}