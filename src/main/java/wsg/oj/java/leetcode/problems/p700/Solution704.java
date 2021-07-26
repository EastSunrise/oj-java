package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 704. Binary Search (EASY)
 *
 * @author Kingen
 * @see Solution702
 * @see <a href="https://leetcode-cn.com/problems/binary-search/">Binary Search</a>
 * @since 2021-07-26
 */
class Solution704 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int search(int[] nums, int target) {
        int i = binarySearch(nums, target);
        return i < 0 ? -1 : i;
    }
}
