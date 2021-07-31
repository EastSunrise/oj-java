package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 812. Largest Triangle Area (EASY)
 *
 * @author Kingen
 * @see Solution976
 * @see <a href="https://leetcode-cn.com/problems/largest-triangle-area/">Largest Triangle Area</a>
 * @since 2021-07-27
 */
public class Solution812 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NNN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    private double area(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
            - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]);
    }
}
