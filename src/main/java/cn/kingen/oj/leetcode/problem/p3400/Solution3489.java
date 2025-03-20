package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/zero-array-transformation-iv/">3489. Zero Array Transformation IV</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3300.Solution3355
 * @see cn.kingen.oj.leetcode.problem.p3300.Solution3356
 * @see cn.kingen.oj.leetcode.problem.p3300.Solution3362
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM,
        contest = 441
)
public class Solution3489 {

    @Complexity(time = "O(n*m*C)", space = "O(C)", note = "C is the max value in nums")
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i], k = 0;
            boolean[] dp = new boolean[num + 1];
            dp[0] = true;
            while (k < m && !dp[num]) {
                if (i >= queries[k][0] && i <= queries[k][1]) {
                    int v = queries[k][2];
                    for (int j = num; j >= v; j--) {
                        dp[j] |= dp[j - v];
                    }
                }
                k++;
            }

            if (!dp[num]) {
                return -1;
            }
            ans = Math.max(ans, k);
        }
        return ans;
    }
}