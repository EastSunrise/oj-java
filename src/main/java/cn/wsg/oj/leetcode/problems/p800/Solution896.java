package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 896. Monotonic Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/monotonic-array/">Monotonic Array</a>
 */
public class Solution896 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
