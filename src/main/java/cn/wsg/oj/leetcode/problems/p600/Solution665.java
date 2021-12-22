package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 665. Non-decreasing Array (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/non-decreasing-array/">Non-decreasing Array</a>
 */
public class Solution665 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
