package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/">2369. Check if There is a Valid Partition For The Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2963
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2369 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        // dp[i]: whether nums[0,i-1] is valid
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[2] = nums[0] == nums[1];

        for (int i = 2; i < n; i++) {
            int dif = nums[i] - nums[i - 1];
            if (dif == 0) {
                dp[i + 1] = dp[i - 1] || (nums[i - 1] == nums[i - 2] && dp[i - 2]);
            } else if (dif == 1 && nums[i - 1] == nums[i - 2] + 1) {
                dp[i + 1] = dp[i - 2];
            }
        }
        return dp[n];
    }
}