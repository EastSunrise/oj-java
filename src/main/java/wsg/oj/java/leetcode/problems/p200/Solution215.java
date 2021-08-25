package wsg.oj.java.leetcode.problems.p200;

import java.util.Random;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution324;
import wsg.oj.java.leetcode.problems.p300.Solution347;
import wsg.oj.java.leetcode.problems.p400.Solution414;
import wsg.oj.java.leetcode.problems.p700.Solution703;

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
public class Solution215 implements Solution {

    /**
     * Quick selection.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_LOG_N
     */
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k, 0, nums.length);
    }

    protected int findKthSmallest(int[] nums, int k, int fromIn, int toEx) {
        int pivot = nums[new Random().nextInt(toEx - fromIn) + fromIn];
        int left = fromIn, right = toEx - 1;
        while (left <= right) {
            if (nums[left] <= pivot) {
                left++;
            } else if (nums[right] > pivot) {
                right--;
            } else {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = tmp;
            }
        }
        int mid = fromIn;
        while (mid <= right) {
            if (nums[mid] == pivot) {
                int tmp = nums[mid];
                nums[mid] = nums[right];
                nums[right--] = tmp;
            } else {
                mid++;
            }
        }
        if (k <= right) {
            return findKthSmallest(nums, k, fromIn, mid);
        }
        if (k >= left) {
            return findKthSmallest(nums, k, left, toEx);
        }
        return pivot;
    }
}
