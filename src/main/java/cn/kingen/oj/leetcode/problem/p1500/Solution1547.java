package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/">1547. Minimum Cost to Cut a Stick</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2147
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3013
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution1547 {

    @Complexity(time = "O(n^3)", space = "O(n^2)")
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length + 2;
        int[] copy = new int[m];
        System.arraycopy(cuts, 0, copy, 1, m - 2);
        copy[0] = 0;
        copy[m - 1] = n;

        // dp[i][j] represents the minimum cost to cut the stick [copy[i], copy[j]], i < j
        int[][] dp = new int[m][m];
        for (int l = 2; l < m; l++) {
            for (int j = l; j < m; j++) { // stick [copy[i], copy[j]], i+l=j
                int i = j - l;
                int min = Integer.MAX_VALUE, stick = copy[j] - copy[i];
                for (int k = i + 1; k < j; k++) { // cut at position copy[k]
                    min = Math.min(min, dp[i][k] + dp[k][j] + stick);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][m - 1];
    }
}