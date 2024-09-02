package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/maximum-xor-score-subarray-queries/">3277. Maximum XOR Score Subarray Queries</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1787
 */
@Question(
        difficulty = Difficulty.HARD
)
public class Solution3277 {

    @Complexity(time = "O(n^2+q)", space = "O(n^2+q)")
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        // xor[k][i]: the xor value of nums[i,...,i+k-1]
        // max[k][i]: the maximum xor value of sub-arrays of nums[i,...,i+k-1]
        int[][] xor = new int[n + 1][n], max = new int[n + 1][n];
        for (int i = 0; i < n; i++) {
            max[1][i] = xor[1][i] = nums[i];
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0, l = n - k; i <= l; i++) {
                xor[k][i] = xor[k - 1][i] ^ xor[k - 1][i + 1];
                max[k][i] = Math.max(Math.max(max[k - 1][i], max[k - 1][i + 1]), xor[k][i]);
            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = max[r - l + 1][l];
        }
        return ans;
    }
}