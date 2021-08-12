package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution148;
import wsg.oj.java.leetcode.problems.p300.Solution324;

/**
 * 75. Sort Colors (Medium)
 *
 * @author Kingen
 * @see Solution148
 * @see Solution280
 * @see Solution324
 * @see <a href="https://leetcode-cn.com/problems/sort-colors/">Sort Colors</a>
 * @since 2021-07-11
 */
public class Solution75 implements Solution {

    /**
     * Selection sort.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 0) {
                left++;
            } else if (nums[right] != 0) {
                right--;
            } else {
                nums[right--] = nums[left];
                nums[left++] = 0;
            }
        }
        right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 1) {
                left++;
            } else if (nums[right] == 2) {
                right--;
            } else {
                nums[left++] = 1;
                nums[right--] = 2;
            }
        }
    }
}
