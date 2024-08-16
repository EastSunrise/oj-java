package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-difference-score-in-a-grid/">3148. Maximum Difference Score in a Grid</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3225
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution3148 {

    @Complexity(time = "O(m*n)", space = "O(n)")
    public int maxScore(List<List<Integer>> grid) {
        List<Integer> row0 = grid.getFirst();
        int m = grid.size(), n = row0.size();
        int[] dp = new int[n];
        dp[0] = row0.getFirst();
        int ans = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++) {
            int val = row0.get(j);
            ans = Math.max(ans, val - dp[j - 1]);
            dp[j] = Math.min(dp[j - 1], val);
        }
        for (int i = 1; i < m; i++) {
            List<Integer> row = grid.get(i);
            ans = Math.max(ans, row.getFirst() - dp[0]);
            dp[0] = Math.min(dp[0], row.getFirst());
            for (int j = 1; j < n; j++) {
                int val = row.get(j);
                int min = Math.min(dp[j - 1], dp[j]);
                ans = Math.max(ans, val - min);
                dp[j] = Math.min(min, val);
            }
        }
        return ans;
    }
}