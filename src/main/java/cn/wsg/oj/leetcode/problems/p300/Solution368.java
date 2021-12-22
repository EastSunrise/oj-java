package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/largest-divisible-subset/">Largest Divisible
 * Subset</a>
 */
public class Solution368 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_N
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
