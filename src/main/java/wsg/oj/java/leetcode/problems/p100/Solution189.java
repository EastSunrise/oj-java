package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution61;

/**
 * 189. Rotate Array (Medium)
 *
 * @author Kingen
 * @see Solution61
 * @see Solution186
 * @see <a href="https://leetcode-cn.com/problems/rotate-array/">Rotate Array</a>
 * @since 2021-07-12
 */
public class Solution189 implements Solution {

    /**
     * Reverses the array, the left k numbers and the right remaining numbers respectively.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
