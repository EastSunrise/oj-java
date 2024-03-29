package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Random;

/**
 * 478. Generate Random Point in a Circle (Medium)
 *
 * @author Kingen
 * @see Solution497
 * @see <a href="https://leetcode-cn.com/problems/generate-random-point-in-a-circle/">Generate
 * Random Point in a Circle</a>
 */
public class Solution478 implements Solution {

    static class Solution {

        private final double radius;
        private final double x0;
        private final double y0;
        private final Random random = new Random();

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x0 = x_center;
            this.y0 = y_center;
        }

        public double[] randPoint() {
            // the random of rho must be in the range from 0 to r^2
            double rho = Math.sqrt(random.nextDouble() * radius * radius);
            double theta = random.nextDouble() * 2 * Math.PI;
            return new double[]{
                x0 + rho * Math.cos(theta),
                y0 + rho * Math.sin(theta)
            };
        }
    }
}
