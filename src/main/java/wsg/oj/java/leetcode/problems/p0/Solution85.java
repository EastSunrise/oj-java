package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution221;

/**
 * 85. Maximal Rectangle (HARD)
 *
 * @author Kingen
 * @see Solution84
 * @see Solution221
 * @see <a href="https://leetcode-cn.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 * @since 2021-07-19
 */
public class Solution85 extends Solution84 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];
        for (int j = 0; j < n; j++) {
            heights[j] = matrix[0][j] - '0';
        }
        int max = largestRectangleArea(heights);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }
}
