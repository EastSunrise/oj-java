package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-i/">3065. Minimum Operations to Exceed Threshold Value I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution35
 * @see cn.kingen.oj.leetcode.problem.p100.Solution169

 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY,
        date = "2025-01-14"
)
public class Solution3065 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                ans++;
            }
        }
        return ans;
    }
}