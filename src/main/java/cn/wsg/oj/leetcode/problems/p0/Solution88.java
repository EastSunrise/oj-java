package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p900.Solution977;

/**
 * 88. Merge Sorted Array (Easy)
 *
 * @author Kingen
 * @see Solution21
 * @see Solution977
 * @see Solution986
 * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 */
public class Solution88 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[k--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }
}
