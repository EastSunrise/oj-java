package wsg.oj.java.leetcode.problems.interview.ch10;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 面试题 10.9. Sorted Matrix Search LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sorted-matrix-search-lcci/">Sorted Matrix Search
 * LCCI</a>
 * @since 2021-07-28
 */
public class Interview9 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
