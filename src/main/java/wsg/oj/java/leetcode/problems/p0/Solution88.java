package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 88. Merge Sorted Array (Easy)
 *
 * @author Kingen
 * @see Solution21
 * @see Solution977
 * @see Solution986
 * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 * @since 2021-07-11
 */
class Solution88 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[index--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
