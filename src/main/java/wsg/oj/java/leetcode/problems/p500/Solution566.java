package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 566. Reshape the Matrix (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reshape-the-matrix/">Reshape the Matrix</a>
 * @since 2021-07-20
 */
public class Solution566 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int i = 0, j = 0;
        for (int[] nums : mat) {
            for (int num : nums) {
                res[i][j++] = num;
                if (j == c) {
                    i++;
                    j = 0;
                }
            }
        }
        return res;
    }
}
