package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 26. Remove Duplicates from Sorted Array (Easy)
 *
 * @author Kingen
 * @see Solution27
 * @see Solution80
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">Remove
 * Duplicates from Sorted Array</a>
 * @since 2021-07-10
 */
class Solution26 implements Solution {

    /**
     * Uses two pointers to copy distinct numbers in-place.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
}
