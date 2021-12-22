package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution278;
import java.util.Arrays;

/**
 * 35. Search Insert Position (Easy)
 *
 * @author Kingen
 * @see Solution278
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position/">Search Insert
 * Position</a>
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
