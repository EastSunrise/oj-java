package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 27. Remove Element (Easy)
 *
 * @author Kingen
 * @see Solution26
 * @see Solution203
 * @see Solution283
 * @see <a href="https://leetcode-cn.com/problems/remove-element/">Remove Element</a>
 * @since 2021-07-10
 */
class Solution27 implements Solution {

    /**
     * It's similar to {@link Solution26}. Use two pointers to copy different numbers in-place.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
