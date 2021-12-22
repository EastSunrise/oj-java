package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution74;

/**
 * 240. Search a 2D Matrix II (Medium)
 *
 * @author Kingen
 * @see Solution74
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 */
public class Solution240 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = m - 1, col = 0;
        while (row >= 0 && col < n) {
            int val = matrix[row][col];
            if (val < target) {
                // next columns
                col++;
            } else if (val > target) {
                // previous rows
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
