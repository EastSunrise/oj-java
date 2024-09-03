package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/rectangle-area/">223. Rectangle Area</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution836
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3027
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3025
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3047
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution223 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = 0;
        // the area of the two rectangles
        area += (ax2 - ax1) * (ay2 - ay1);
        area += (bx2 - bx1) * (by2 - by1);
        // not overlapped
        if (ax1 > bx2 || bx1 > ax2 || ay1 > by2 || by1 > ay2) {
            return area;
        }
        int cx1 = Math.max(ax1, bx1);
        int cy1 = Math.max(ay1, by1);
        int cx2 = Math.min(ax2, bx2);
        int cy2 = Math.min(ay2, by2);
        return area - (cx2 - cx1) * (cy2 - cy1);
    }
}