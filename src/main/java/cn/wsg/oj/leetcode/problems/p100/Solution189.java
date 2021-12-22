package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution61;

/**
 * 189. Rotate Array (Medium)
 *
 * @author Kingen
 * @see Solution61
 * @see Solution186
 * @see <a href="https://leetcode-cn.com/problems/rotate-array/">Rotate Array</a>
 */
public class Solution189 implements Solution {

    /**
     * Reverses the array, the left k numbers and the right remaining numbers respectively.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
