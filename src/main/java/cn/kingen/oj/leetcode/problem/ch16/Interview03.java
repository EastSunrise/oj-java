package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/intersection-lcci/">面试题 16.03. Intersection LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.MATH},
        difficulty = Difficulty.HARD
)
public class Interview03 {

    @Complexity(time = "O(1)", space = "O(1)")
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] > end1[0]) {
            return intersection(end1, start1, start2, end2);
        }
        if (start2[0] > end2[0]) {
            return intersection(start1, end1, end2, start2);
        }

        int x1 = start1[0], y1 = start1[1], x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1], x4 = end2[0], y4 = end2[1];
        if (x1 == x2 && x3 == x4) { // two lines and y-axis are parallel or collinear
            if (x1 != x3) { // parallel
                return new double[0];
            } else { // collinear
                int min1 = Math.min(y1, y2), max1 = Math.max(y1, y2);
                int min2 = Math.min(y3, y4), max2 = Math.max(y3, y4);
                if (min1 > max2 || min2 > max1) {
                    return new double[0];
                }
                return new double[]{x1, Math.max(min1, min2)};
            }
        }
        if (x1 != x2 && x3 != x4) { // none parallel to y-axis
            if ((x2 - x1) * (y4 - y3) == (x4 - x3) * (y2 - y1)) { // two lines are parallel or collinear
                if ((x1 - x3) * (y2 - y3) != (x2 - x3) * (y1 - y3)) { // parallel
                    return new double[0];
                } else { // collinear
                    if (x1 > x4 || x3 > x2) {
                        return new double[0];
                    }
                    if (x1 >= x3) {
                        return new double[]{x1, y1};
                    }
                    return new double[]{x3, y3};
                }
            } else { // two lines intersect
                double k12 = (double) (y2 - y1) / (x2 - x1), k34 = (double) (y4 - y3) / (x4 - x3);
                double b12 = y1 - k12 * x1, b34 = y3 - k34 * x3;
                double x = (b34 - b12) / (k12 - k34), y = k12 * x + b12;
                if (x >= x1 && x <= x2 && x >= x3 && x <= x4) { // intersection is on the line segments
                    return new double[]{x, y};
                }
                return new double[0];
            }
        }
        if (x1 != x2) {
            return intersection(start2, end2, start1, end1);
        }
        // x1==x2 && x3!=x4
        if (x1 < x3 || x1 > x4) {
            return new double[0];
        }
        double k34 = (double) (y4 - y3) / (x4 - x3), b34 = y3 - k34 * x3;
        double y = k34 * x1 + b34;
        if (y >= Math.min(y1, y2) && y <= Math.max(y1, y2)) {
            return new double[]{x1, y};
        }
        return new double[0];
    }
}