package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution240;
import java.util.Arrays;

/**
 * 74. Search a 2D Matrix (Medium)
 *
 * @author Kingen
 * @see Solution240
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 */
public class Solution74 implements Solution {

    /**
     * Searches from the bottom-left corner.
     *
     * @complexity T=O(log(m+n))
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int top = 0, bot = m - 1;
        while (top <= bot) {
            int mid = (top + bot) >>> 1;
            int midVal = matrix[mid][0];
            if (midVal < target) {
                top = mid + 1;
            } else if (midVal > target) {
                bot = mid - 1;
            } else {
                return true;
            }
        }
        return bot >= 0 && Arrays.binarySearch(matrix[bot], target) >= 0;
    }
}
