package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 896. Monotonic Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/monotonic-array/">Monotonic Array</a>
 * @since 2021-07-27
 */
public class Solution896 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i] >= nums[i - 1]) {
            i++;
        }
        if (i == n) {
            return true;
        }
        i = 1;
        while (i < n && nums[i] <= nums[i - 1]) {
            i++;
        }
        return i == n;
    }
}
