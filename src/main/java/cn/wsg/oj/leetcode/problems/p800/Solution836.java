package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution223;

/**
 * 836. Rectangle Overlap (EASY)
 *
 * @author Kingen
 * @see Solution223
 * @see <a href="https://leetcode-cn.com/problems/rectangle-overlap/">Rectangle Overlap</a>
 */
public class Solution836 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec1[2] && rec1[1] < rec1[3] && rec2[0] < rec2[2] && rec2[1] < rec2[3] &&
            rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1];
    }
}
