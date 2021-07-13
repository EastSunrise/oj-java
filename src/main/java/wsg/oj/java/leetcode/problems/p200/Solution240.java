package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution74;

/**
 * 240. Search a 2D Matrix II (Medium)
 *
 * @author Kingen
 * @see Solution74
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 * @since 2021-07-13
 */
public class Solution240 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int bottom = m - 1, left = 0;
        while (bottom >= 0 && left < n) {
            int bl = matrix[bottom][left];
            if (bl < target) {
                // next columns
                left++;
            } else if (bl > target) {
                // previous rows
                bottom--;
            } else {
                return true;
            }
        }
        return false;
    }
}
