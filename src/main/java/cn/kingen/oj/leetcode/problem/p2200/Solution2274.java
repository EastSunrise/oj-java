package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/">2274. Maximum Consecutive Floors Without Special Floors</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution128
 * @see cn.kingen.oj.leetcode.problem.p100.Solution164
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-06"
)
public class Solution2274 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = 0, prev = bottom - 1;
        for (int x : special) {
            ans = Math.max(ans, x - prev - 1);
            prev = x;
        }
        return Math.max(ans, top - prev);
    }
}