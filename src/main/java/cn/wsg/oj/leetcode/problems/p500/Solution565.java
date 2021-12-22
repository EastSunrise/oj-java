package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution341;

/**
 * 565. Array Nesting (MEDIUM)
 *
 * @author Kingen
 * @see Solution339
 * @see Solution341
 * @see Solution364
 * @see <a href="https://leetcode-cn.com/problems/array-nesting/">Array Nesting</a>
 */
public class Solution565 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
