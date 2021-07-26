package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution341;

/**
 * 565. Array Nesting (MEDIUM)
 *
 * @author Kingen
 * @see Solution339
 * @see Solution341
 * @see Solution364
 * @see <a href="https://leetcode-cn.com/problems/array-nesting/">Array Nesting</a>
 * @since 2021-07-20
 */
public class Solution565 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int arrayNesting(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                continue;
            }
            int count = 0, j = i;
            while (nums[j] >= 0) {
                count++;
                nums[j] = -nums[j] - 1;
                j = -nums[j] - 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
