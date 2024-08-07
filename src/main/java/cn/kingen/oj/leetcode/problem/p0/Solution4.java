package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DIVIDE_AND_CONQUER},
        difficulty = Difficulty.HARD
)
public class Solution4 {

    @Complexity(time = "O(log{m+n})", space = "O(1)")
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = m - 1, half = (m + n - 1) / 2;
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = half - i;
            if (j < 0) {
                high = i - 1;
            } else if (j >= n) {
                low = i + 1;
            } else if (nums1[i] < nums2[j]) {
                low = i + 1;
            } else if (nums1[i] > nums2[j]) {
                high = i - 1;
            } else {
                return nums1[i];
            }
        }
        // the possible medians of nums1: nums1[high], nums1[low]
        // the possible medians of nums2: nums2[half-low], nums2[half-high]
        int median1 = Integer.MIN_VALUE;
        if (high >= 0) {
            median1 = Math.max(median1, nums1[high]);
        }
        if (half - low >= 0) {
            median1 = Math.max(median1, nums2[half - low]);
        }
        if ((m + n) % 2 == 1) {
            return median1;
        }
        int median2 = Integer.MAX_VALUE;
        if (low < m) {
            median2 = Math.min(median2, nums1[low]);
        }
        if (half - high < n) {
            median2 = Math.min(median2, nums2[half - high]);
        }
        return (median1 + median2) / 2.0;
    }
}