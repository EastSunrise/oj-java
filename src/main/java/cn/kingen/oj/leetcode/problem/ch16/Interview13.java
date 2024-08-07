package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/bisect-squares-lcci/">面试题 16.13. Bisect Squares LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Interview13 {

    @Complexity(time = "O(1)", space = "O(1)")
    public double[] cutSquares(int[] square1, int[] square2) {
        int lbx1 = square1[0], lby1 = square1[1], lbx2 = square2[0], lby2 = square2[1];
        int length1 = square1[2], length2 = square2[2];
        int rtx1 = lbx1 + length1, rty1 = lby1 + length1, rtx2 = lbx2 + length2, rty2 = lby2 + length2;
        double half1 = (double) square1[2] / 2, half2 = (double) square2[2] / 2;
        double cx1 = lbx1 + half1, cy1 = lby1 + half1;
        double cx2 = lbx2 + half2, cy2 = lby2 + half2;
        if (cx1 == cx2) { // parallel to y-axis
            return new double[]{cx1, Math.min(lby1, lby2), cx1, Math.max(rty1, rty2)};
        }

        double k = (cy2 - cy1) / (cx2 - cx1);
        double b = cy1 - k * cx1;
        if (k >= 1 || k <= -1) { // intersect with bottom or top sides
            double y1 = Math.min(lby1, lby2), y2 = Math.max(rty1, rty2);
            double x1 = (y1 - b) / k, x2 = (y2 - b) / k;
            if (x1 < x2) {
                return new double[]{x1, y1, x2, y2};
            } else {
                return new double[]{x2, y2, x1, y1};
            }
        } else { // intersect with left or right sides
            double x1 = Math.min(lbx1, lbx2), x2 = Math.max(rtx1, rtx2);
            double y1 = k * x1 + b, y2 = k * x2 + b;
            return new double[]{x1, y1, x2, y2};
        }
    }
}