package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/largest-divisible-subset/">368. Largest Divisible Subset</a>
 *
 * @author Kingen
 */
@Question(
    tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-06"
)
public class Solution368 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int mxi = 0;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[]{1, -1};
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if (dp[i][0] > dp[mxi][0]) {
                mxi = i;
            }
        }

        List<Integer> ans = new ArrayList<>(dp[mxi][0]);
        for (int i = mxi; i >= 0; i = dp[i][1]) {
            ans.add(nums[i]);
        }
        return ans;
    }
}