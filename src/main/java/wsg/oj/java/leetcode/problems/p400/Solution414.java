package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution215;

/**
 * 414. Third Maximum Number (Easy)
 *
 * @author Kingen
 * @see Solution215
 * @see <a href="https://leetcode-cn.com/problems/third-maximum-number/">Third Maximum Number</a>
 * @since 2021-07-14
 */
public class Solution414 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
        }
        Integer max2 = maxLessThan(nums, max);
        if (max2 == null) {
            return max;
        }
        Integer max3 = maxLessThan(nums, max2);
        return max3 == null ? max : max3;
    }

    private Integer maxLessThan(int[] nums, int n) {
        Integer max = null;
        for (int num : nums) {
            if (num < n) {
                if (max == null || max < num) {
                    max = num;
                }
            }
        }
        return max;
    }
}
