package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 223. Rectangle Area (Medium)
 *
 * @author Kingen
 * @see Solution836
 * @see <a href="https://leetcode-cn.com/problems/rectangle-area/">Rectangle Area</a>
 * @since 2021-07-13
 */
class Solution223 implements Solution {

    /**
     * Deletes the common area if overlapping.
     *
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
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
