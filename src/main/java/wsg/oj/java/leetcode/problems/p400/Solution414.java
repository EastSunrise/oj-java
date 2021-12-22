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
        int max = nums[0];
        Integer max2 = null, max3 = null;
        for (int num : nums) {
            if (num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            } else if (num < max) {
                if (max2 == null) {
                    max2 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num < max2 && (max3 == null || num > max3)) {
                    max3 = num;
                }
            }
        }
        return max3 == null ? max : max3;
    }
}
