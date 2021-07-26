package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.p200.Solution215;

/**
 * 462. Minimum Moves to Equal Array Elements II (Medium)
 *
 * @author Kingen
 * @see Solution296
 * @see Solution453
 * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/">Minimum
 * Moves to Equal Array Elements II</a>
 * @since 2021-07-09
 */
public class Solution462 extends Solution215 {

    /**
     * Finds the median.
     * <p>
     * If the length is even and the two medians are x and y, any integer between x and y are
     * optional.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minMoves2(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }
}
