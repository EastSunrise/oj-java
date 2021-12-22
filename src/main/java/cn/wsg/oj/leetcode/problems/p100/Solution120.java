package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.List;

/**
 * 120. Triangle (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/triangle/">Triangle</a>
 */
public class Solution120 implements Solution {

    /**
     * Traverses the triangle level by level from bottom to top.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_N
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        List<Integer> bottom = triangle.get(size - 1);
        for (int i = 0; i < size; i++) {
            dp[i] = bottom.get(i);
        }
        for (int level = size - 2; level >= 0; level--) {
            List<Integer> values = triangle.get(level);
            for (int i = 0; i <= level; i++) {
                // dp[i]: the minimum path sum of the triangle with vertex [level, i]
                dp[i] = Math.min(dp[i], dp[i + 1]) + values.get(i);
            }
        }
        return dp[0];
    }
}
