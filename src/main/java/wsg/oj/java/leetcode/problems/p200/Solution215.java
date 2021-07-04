package wsg.oj.java.leetcode.problems.p200;

import java.util.Random;
import wsg.oj.java.leetcode.problems.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution324;

/**
 * 215. Kth Largest Element in an Array (Medium)
 *
 * @author Kingen
 * @see Solution324
 * @see Solution347
 * @see Solution414
 * @see Solution703
 * @see Solution973
 * @see <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">Kth Largest
 * Element in an Array</a>
 * @since 2021-07-04
 */
public class Solution215 extends Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length - k, 0, nums.length);
    }

    private int findKthLargest(int[] nums, int k, int fromIn, int toEx) {
        int left = fromIn, right = toEx - 1;
        int target = nums[new Random().nextInt(toEx - fromIn) + fromIn];
        while (left <= right) {
            if (nums[left] <= target) {
                left++;
            } else if (nums[right] > target) {
                right--;
            } else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        int mid = fromIn;
        while (mid <= right) {
            if (nums[mid] == target) {
                int tmp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = tmp;
                right--;
            } else {
                mid++;
            }
        }
        if (k <= right) {
            return findKthLargest(nums, k, fromIn, mid);
        }
        if (k >= left) {
            return findKthLargest(nums, k, left, toEx);
        }
        return target;
    }
}
