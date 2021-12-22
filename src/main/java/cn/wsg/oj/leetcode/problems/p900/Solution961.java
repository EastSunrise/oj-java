package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 961. N-Repeated Element in Size 2N Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated
 * Element in Size 2N Array</a>
 */
public class Solution961 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
