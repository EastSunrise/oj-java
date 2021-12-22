package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 757. Set Intersection Size At Least Two (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/set-intersection-size-at-least-two/">Set
 * Intersection Size At Least Two</a>
 */
public class Solution757 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[1] == a2[1] ? a2[0] - a1[0] : a1[1] - a2[1]);
        // the maximal two of chosen numbers
        int max = -1, max2 = max - 1, size = 0;
        for (int[] interval : intervals) {
            if (interval[0] > max) {
                // add two new numbers if not intersected
                size += 2;
                max = interval[1];
                max2 = max - 1;
            } else if (interval[0] > max2) {
                // add one number if intersected with one number
                size++;
                max2 = max;
                max = interval[1];
            }
        }
        return size;
    }
}
