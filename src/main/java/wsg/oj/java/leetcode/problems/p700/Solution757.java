package wsg.oj.java.leetcode.problems.p700;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 757. Set Intersection Size At Least Two (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/set-intersection-size-at-least-two/">Set
 * Intersection Size At Least Two</a>
 * @since 2021-07-27
 */
public class Solution757 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
