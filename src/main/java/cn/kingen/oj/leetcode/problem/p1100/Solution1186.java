package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/">1186. Maximum Subarray Sum with One Deletion</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1186 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maximumSum(int[] arr) {
        int n = arr.length;
        // dp0: the maximum subarray sum ending with arr[i]
        // dp1: the maximum subarray sum ending with arr[i] and one element deleted
        int dp0 = arr[0], dp1 = 0, ans = dp0;
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(dp1 + arr[i], dp0);
            dp0 = Math.max(dp0 + arr[i], arr[i]);
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }
}