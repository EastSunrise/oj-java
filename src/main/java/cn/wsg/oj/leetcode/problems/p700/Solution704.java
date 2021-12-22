package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 704. Binary Search (EASY)
 *
 * @author Kingen
 * @see Solution702
 * @see <a href="https://leetcode-cn.com/problems/binary-search/">Binary Search</a>
 */
class Solution704 implements Solution {

    /**
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int search(int[] nums, int target) {
        int i = binarySearch(nums, target);
        return i < 0 ? -1 : i;
    }
}
