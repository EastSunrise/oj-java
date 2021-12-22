package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 517. Super Washing Machines (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/super-washing-machines/">Super Washing
 * Machines</a>
 */
public class Solution517 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int total = 0;
        for (int machine : machines) {
            total += machine;
        }
        if (total % n != 0) {
            return -1;
        }
        int average = total / n;

        int max = 0, next = 0;
        for (int i = 0; i < n - 1; i++) {
            int dif = machines[i] - average;
            if (dif < 0) {
                max = Math.max(max, next);
                // move clothes from next machine to this one
                next = -dif;
                machines[i + 1] += dif;
            } else if (dif > 0) {
                // move clothes from this machine to next one
                machines[i + 1] += dif;
                max = Math.max(max, next + dif);
                next = 0;
            }
        }
        return Math.max(max, next);
    }
}
