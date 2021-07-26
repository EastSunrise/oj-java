package wsg.oj.java.leetcode.problems.p1700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1713. Minimum Operations to Make a Subsequence (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/">Minimum
 * Operations to Make a Subsequence</a>
 * @since 2021-07-26
 */
class Solution1713 implements Solution {

    /**
     * @complexity T=O(m+n*log{n})
     * @complexity S=O(m+n)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int minOperations(int[] target, int[] arr) {
        int m = target.length, n = arr.length;
        Map<Integer, Integer> indices = new HashMap<>(target.length);
        for (int i = 0; i < m; i++) {
            indices.put(target[i], i);
        }
        // dp[i]: the min of the last numbers of increasing indices with the length of i
        List<Integer> dp = new ArrayList<>();
        for (int num : arr) {
            if (indices.containsKey(num)) {
                int index = indices.get(num);
                int j = Collections.binarySearch(dp, index);
                if (j < 0) {
                    j = -j - 1;
                }
                if (j == dp.size()) {
                    dp.add(index);
                } else {
                    dp.set(j, index);
                }
            }
        }
        return m - dp.size();
    }

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int minOperations2(int[] target, int[] arr) {
        int m = target.length, n = arr.length;
        // dp[i][j]: the minimal operations between target[0,i-1] and arr[0,j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (target[i - 1] == arr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
