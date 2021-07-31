package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 922. Sort Array By Parity II (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sort-array-by-parity-ii/">Sort Array By Parity
 * II</a>
 * @since 2021-07-27
 */
public class Solution922 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] sortArrayByParityII(int[] nums) {
        int ei = 0, oi = 1, n = nums.length;
        while (ei < n && oi < n) {
            if (nums[ei] % 2 == 0) {
                ei += 2;
            } else if (nums[oi] % 2 == 1) {
                oi += 2;
            } else {
                nums[ei] += nums[oi];
                nums[oi] = nums[ei] - nums[oi];
                nums[ei] -= nums[oi];
                ei += 2;
                oi += 2;
            }
        }
        return nums;
    }
}
