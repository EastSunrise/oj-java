package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 149. Max Points on a Line (HARD)
 *
 * @author Kingen
 * @see Solution356
 * @see <a href="https://leetcode-cn.com/problems/max-points-on-a-line/">Max Points on a Line</a>
 * @since 2021-07-27
 */
public class Solution149 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NNN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1, dy = y2 - y1;
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    if ((points[k][1] - y1) * dx == (points[k][0] - x1) * dy) {
                        count++;
                    }
                }
                max = Math.max(max, count);
                if (max > n / 2) {
                    return max;
                }
            }
        }
        return max;
    }
}
