package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.Solution;

/**
 * 368. Largest Divisible Subset (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/largest-divisible-subset/">Largest Divisible
 * Subset</a>
 * @since 2021-07-04
 */
class Solution368 extends Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_NN
     * @see #SPACE_N
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1, idx = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<>(max);
        for (int i = idx; i >= 0; i--) {
            if (nums[idx] % nums[i] == 0 && dp[i] == max) {
                res.add(nums[i]);
                idx = i;
                max--;
            }
        }
        return res;
    }
}
