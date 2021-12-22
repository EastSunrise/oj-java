package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 883. Projection Area of 3D Shapes (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/projection-area-of-3d-shapes/">Projection Area of
 * 3D Shapes</a>
 */
public class Solution883 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
     */
    public int projectionArea(int[][] grid) {
        int vertical = 0;
        for (int[] yz : grid) {
            for (int z : yz) {
                if (z > 0) {
                    vertical++;
                }
            }
        }
        int main = 0;
        for (int[] yz : grid) {
            int max = 0;
            for (int z : yz) {
                max = Math.max(max, z);
            }
            main += max;
        }
        int left = 0;
        int n = grid.length;
        for (int y = 0; y < n; y++) {
            int max = 0;
            for (int[] yz : grid) {
                max = Math.max(max, yz[y]);
            }
            left += max;
        }
        return vertical + main + left;
    }
}
