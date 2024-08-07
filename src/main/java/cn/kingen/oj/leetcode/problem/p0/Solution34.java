package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution278
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution34 {

    @Complexity(time = "O(log n)", space = "O(1)")
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low == nums.length || nums[low] != target) {
            return new int[]{-1, -1};
        }
        int start = low;

        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{start, high};
    }
}