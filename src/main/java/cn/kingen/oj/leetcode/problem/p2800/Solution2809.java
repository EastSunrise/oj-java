package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/">2809. Minimum Time to Make Array Sum At Most x</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution2809 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), sum1 = 0, sum2 = 0;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            int num1 = nums1.get(i), num2 = nums2.get(i);
            nums[i][0] = num1;
            nums[i][1] = num2;
            sum1 += num1;
            sum2 += num2;
        }
        Arrays.sort(nums, Comparator.comparing(t -> t[1]));

        // dp[i]: the maximum total value that can be reduced by i operations
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int num1 = nums[i][0], num2 = nums[i][1];
            for (int j = i + 1; j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + num1 + j * num2);
            }
        }
        for (int j = 0; j <= n; j++) {
            if (sum2 * j + sum1 - dp[j] <= x) {
                return j;
            }
        }
        return -1;
    }
}