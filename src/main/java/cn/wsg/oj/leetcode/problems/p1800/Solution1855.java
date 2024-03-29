package cn.wsg.oj.leetcode.problems.p1800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1855. Maximum Distance Between a Pair of Values (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-distance-between-a-pair-of-values/">Maximum
 * Distance Between a Pair of Values</a>
 */
public class Solution1855 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] > nums2[p2]) {
                p1++;
            }
            p2++;
        }
        return Math.max(p2 - p1 - 1, 0);
    }
}
