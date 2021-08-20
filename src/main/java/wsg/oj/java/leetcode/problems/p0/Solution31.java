package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 31. Next Permutation (Medium)
 *
 * @author Kingen
 * @see Solution46
 * @see Solution47
 * @see Solution60
 * @see Solution267
 * @see Solution1850
 * @see <a href="https://leetcode-cn.com/problems/next-permutation/">Next Permutation</a>
 * @since 2021-07-10
 */
class Solution31 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int i = len - 1;
        // find the longest subarray which is in ascending order from the end
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        // rearrange the subarray from descending order to ascending order with two pointers
        for (int left = i, right = len - 1; left < right; left++, right--) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        if (i > 0) {
            // find the smallest number from the subarray strictly larger than nums[i-1]
            // and then swap the two numbers
            int left = i, right = len - 1, target = nums[i - 1];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[left];
            nums[left] = temp;
        }
    }
}
