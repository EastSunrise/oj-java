package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 665. Non-decreasing Array (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/non-decreasing-array/">Non-decreasing Array</a>
 * @since 2021-07-23
 */
public class Solution665 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean checkPossibility(int[] nums) {
        int i = 1, n = nums.length;
        while (i < n && nums[i - 1] <= nums[i]) {
            i++;
        }
        if (i == n) {
            return true;
        }
        if (i == 1 || nums[i - 2] <= nums[i]) {
            nums[i - 1] = nums[i];
        } else {
            nums[i] = nums[i - 1];
        }
        i++;
        while (i < n && nums[i - 1] <= nums[i]) {
            i++;
        }
        return i == n;
    }
}
