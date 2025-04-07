package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/">416. Partition Equal Subset Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution698
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1981
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2025
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2035
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2395
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2518
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2578
 */
@Question(
    tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-07"
)
public class Solution416 {

    @Complexity(time = "O(n*target)", space = "O(target)", note = "target = sum / 2")
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}