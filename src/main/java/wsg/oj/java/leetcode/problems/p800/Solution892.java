package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 892. Surface Area of 3D Shapes (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/surface-area-of-3d-shapes/">Surface Area of 3D
 * Shapes</a>
 * @since 2021-07-27
 */
public class Solution892 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int surfaceArea(int[][] grid) {
        int vertical = 0;
        for (int[] yz : grid) {
            for (int z : yz) {
                if (z > 0) {
                    vertical += 2;
                }
            }
        }
        int n = grid.length;
        int main = 0;
        for (int[] yz : grid) {
            main += yz[0];
            for (int y = 1; y < n; y++) {
                main += Math.abs(yz[y] - yz[y - 1]);
            }
            main += yz[n - 1];
        }
        int left = 0;
        for (int y = 0; y < n; y++) {
            left += grid[0][y];
            for (int x = 1; x < n; x++) {
                main += Math.abs(grid[x][y] - grid[x - 1][y]);
            }
            left += grid[n - 1][y];
        }
        return vertical + main + left;
    }
}
