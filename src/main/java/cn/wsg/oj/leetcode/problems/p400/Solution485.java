package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1000.Solution1004;
import cn.wsg.oj.leetcode.problems.p1400.Solution1446;
import cn.wsg.oj.leetcode.problems.p1800.Solution1869;

/**
 * 485. Max Consecutive Ones (Easy)
 *
 * @author Kingen
 * @see Solution487
 * @see Solution1004
 * @see Solution1446
 * @see Solution1869
 * @see <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 */
public class Solution485 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}
