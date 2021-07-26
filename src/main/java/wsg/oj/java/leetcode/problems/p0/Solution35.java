package wsg.oj.java.leetcode.problems.p0;

import java.util.Arrays;
import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution278;

/**
 * 35. Search Insert Position (Easy)
 *
 * @author Kingen
 * @see Solution278
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position/">Search Insert
 * Position</a>
 * @since 2021-07-10
 */
public class Solution35 implements Solution {

    /**
     * @see Arrays#binarySearch(int[], int)
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int searchInsert(int[] nums, int target) {
        int i = binarySearch(nums, target);
        return i < 0 ? -i - 1 : i;
    }
}
