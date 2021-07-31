package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution223;

/**
 * 836. Rectangle Overlap (EASY)
 *
 * @author Kingen
 * @see Solution223
 * @see <a href="https://leetcode-cn.com/problems/rectangle-overlap/">Rectangle Overlap</a>
 * @since 2021-07-27
 */
public class Solution836 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec1[2] && rec1[1] < rec1[3] && rec2[0] < rec2[2] && rec2[1] < rec2[3] &&
            rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1];
    }
}
