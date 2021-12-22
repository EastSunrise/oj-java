package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 4. Median of Two Sorted Arrays (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted
 * Arrays</a>
 */
public class Solution4 implements Solution {

    /**
     * @complexity T=O(k), k=log{min(m,n)}
     * @complexity S=O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = m - 1, mid = (m + n - 1) / 2;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid - mid1;
            if (mid2 < 0) {
                high = mid1 - 1;
            } else if (mid2 >= n) {
                low = mid1 + 1;
            } else if (nums1[mid1] < nums2[mid2]) {
                low = mid1 + 1;
            } else if (nums1[mid1] > nums2[mid2]) {
                high = mid1 - 1;
            } else {
                return nums1[mid1];
            }
        }
        // the possible medians of nums1: nums1[high], nums1[low]
        // the possible medians of nums2: nums2[mid-low], nums2[mid-high]
        int median1 = Integer.MIN_VALUE;
        if (high >= 0) {
            median1 = Math.max(median1, nums1[high]);
        }
        if (mid - low >= 0) {
            median1 = Math.max(median1, nums2[mid - low]);
        }
        if ((m + n) % 2 == 1) {
            return median1;
        }
        int median2 = Integer.MAX_VALUE;
        if (low < m) {
            median2 = Math.min(median2, nums1[low]);
        }
        if (mid - high < n) {
            median2 = Math.min(median2, nums2[mid - high]);
        }
        return (median1 + median2) / 2.0;
    }
}
