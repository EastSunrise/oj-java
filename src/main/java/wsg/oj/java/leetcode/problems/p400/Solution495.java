package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution56;
import wsg.oj.java.leetcode.problems.p600.Solution605;

/**
 * 495. Teemo Attacking (Easy)
 *
 * @author Kingen
 * @see Solution56
 * @see Solution605
 * @see Solution649
 * @see <a href="https://leetcode-cn.com/problems/teemo-attacking/">Teemo Attacking</a>
 * @since 2021-07-14
 */
public class Solution495 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int lastEnd = 0, notPoisoned = 0;
        for (int time : timeSeries) {
            if (time > lastEnd) {
                notPoisoned += time - lastEnd;
            }
            lastEnd = time + duration;
        }
        return timeSeries[timeSeries.length - 1] + duration - notPoisoned;
    }
}
