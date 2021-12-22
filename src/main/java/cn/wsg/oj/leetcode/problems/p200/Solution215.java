package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution324;
import cn.wsg.oj.leetcode.problems.p300.Solution347;
import cn.wsg.oj.leetcode.problems.p400.Solution414;
import cn.wsg.oj.leetcode.problems.p700.Solution703;
import cn.wsg.oj.leetcode.problems.p900.Solution973;
import java.util.Random;

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
 */
public class Solution215 implements Solution {

    /**
     * Quick selection.
     *
     * @param k 0-indexed
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_LOG_N
     */
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k, 0, nums.length);
    }

    protected int findKthSmallest(int[] nums, int k, int fromIn, int toEx) {
        int pivot = new Random().nextInt(toEx - fromIn) + fromIn;
        swap(nums, pivot, fromIn);
        int low = fromIn + 1, high = toEx - 1;
        while (low <= high) {
            if (nums[low] <= nums[fromIn]) {
                low++;
            } else if (nums[high] > nums[fromIn]) {
                high--;
            } else {
                int tmp = nums[low];
                nums[low++] = nums[high];
                nums[high--] = tmp;
            }
        }
        swap(nums, fromIn, high);
        if (k == low) {
            return nums[high];
        }
        if (k < low) {
            return findKthSmallest(nums, k, fromIn, high);
        }
        return findKthSmallest(nums, k, low, toEx);
    }
}
