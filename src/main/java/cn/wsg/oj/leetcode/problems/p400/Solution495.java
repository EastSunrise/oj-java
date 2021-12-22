package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution56;
import cn.wsg.oj.leetcode.problems.p600.Solution605;

/**
 * 495. Teemo Attacking (Easy)
 *
 * @author Kingen
 * @see Solution56
 * @see Solution605
 * @see Solution649
 * @see <a href="https://leetcode-cn.com/problems/teemo-attacking/">Teemo Attacking</a>
 */
public class Solution495 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
