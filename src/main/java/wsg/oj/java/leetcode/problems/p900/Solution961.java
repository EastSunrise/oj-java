package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 961. N-Repeated Element in Size 2N Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated
 * Element in Size 2N Array</a>
 * @since 2021-07-27
 */
public class Solution961 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        for (int d = 1; d <= 3; d++) {
            for (int i = d; i < n; i++) {
                if (nums[i] == nums[i - d]) {
                    return nums[i];
                }
            }
        }
        throw new IllegalArgumentException("Not found");
    }
}
