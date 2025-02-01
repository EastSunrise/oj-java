package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/">81. Search in Rotated Sorted Array II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution33
 */
@Question(
    tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
    difficulty = Difficulty.MEDIUM
)
public class Solution81 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal == target) {
                return true;
            }
            if (midVal < nums[low]) {
                if (midVal < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (midVal > nums[low]) {
                if (nums[low] <= target && target < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // cannot determine the order
                return search(nums, target, low, mid - 1)
                    || search(nums, target, mid + 1, high);
            }
        }
        return false;
    }
}