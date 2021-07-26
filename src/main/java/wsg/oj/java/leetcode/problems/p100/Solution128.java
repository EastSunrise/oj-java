package wsg.oj.java.leetcode.problems.p100;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * todo 128. Longest Consecutive Sequence (Medium)
 *
 * @author Kingen
 * @see Solution298
 * @see <a href="https://leetcode-cn.com/problems/longest-consecutive-sequence/">Longest Consecutive
 * Sequence</a>
 * @since 2021-07-11
 */
public class Solution128 implements Solution {

    /**
     * Sorts and finds.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1, count = 1, last = nums[0];
        for (int i = 1; i < len; i++) {
            int dif = nums[i] - last;
            if (dif > 0) {
                if (dif > 1) {
                    max = Math.max(max, count);
                    count = 1;
                } else {
                    count++;
                }
                last = nums[i];
            }
        }
        return Math.max(max, count);
    }
}
