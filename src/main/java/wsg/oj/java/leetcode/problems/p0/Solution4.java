package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 4. Median of Two Sorted Arrays (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted
 * Arrays</a>
 * @since 2021-07-16
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
        int left = 0, right = m - 1, mid = (m + n - 1) / 2;
        while (left <= right) {
            int mid1 = (left + right) >>> 1;
            int mid2 = mid - mid1;
            if (mid2 < 0) {
                right = mid1 - 1;
            } else if (mid2 >= n) {
                left = mid1 + 1;
            } else if (nums1[mid1] < nums2[mid2]) {
                left = mid1 + 1;
            } else if (nums1[mid1] > nums2[mid2]) {
                right = mid1 - 1;
            } else {
                return nums1[mid1];
            }
        }
        // the possible medians of nums1: nums1[right], nums1[left]
        // the possible medians of nums2: nums2[mid-left], nums2[mid-right]
        int median1 = Integer.MIN_VALUE;
        if (right >= 0) {
            median1 = Math.max(median1, nums1[right]);
        }
        if (mid - left >= 0) {
            median1 = Math.max(median1, nums2[mid - left]);
        }
        if ((m + n) % 2 == 1) {
            return median1;
        }
        int median2 = Integer.MAX_VALUE;
        if (left < m) {
            median2 = Math.min(median2, nums1[left]);
        }
        if (mid - right < n) {
            median2 = Math.min(median2, nums2[mid - right]);
        }
        return (median1 + median2) / 2.0;
    }
}
