package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 498. Diagonal Traverse (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/diagonal-traverse/">Diagonal Traverse</a>
 * @since 2021-07-09
 */
class Solution498 implements Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, mn = m * n;
        int[] res = new int[mn], dx = new int[]{-1, 1};
        int i = 0, j = 0, k = 0;
        while (k < mn) {
            res[k++] = mat[i][j];
            i += dx[0];
            j += dx[1];
            if (0 <= i && i < m && 0 <= j && j < n) {
                continue;
            }
            // turn around
            if (j == n) {
                i += 2;
                j--;
            } else if (i < 0) {
                i++;
            } else if (i == m) {
                j += 2;
                i--;
            } else if (j < 0) {
                j++;
            }
            dx[0] = -dx[0];
            dx[1] = -dx[1];
        }
        return res;
    }
}
