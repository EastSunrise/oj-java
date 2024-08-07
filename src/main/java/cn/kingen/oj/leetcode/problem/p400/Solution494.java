package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/target-sum/">494. Target Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution282
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution494 {

    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{5, 2, 2, 7, 3, 7, 9, 0, 2, 3}, 9));
    }

    /**
     * Assumes the sum of plus numbers is p, then p=(sum+target)/2.
     */
    @Complexity(time = "O(n*p)", space = "O(p)", note = "p=(sum+target)/2")
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum ^ target) & 1) == 1 || sum < -target) {
            return 0;
        }
        int p = (sum + target) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[p];
    }
}