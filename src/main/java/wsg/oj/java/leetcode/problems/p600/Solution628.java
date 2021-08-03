package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution152;

/**
 * 628. Maximum Product of Three Numbers (EASY)
 *
 * @author Kingen
 * @see Solution152
 * @see <a href="https://leetcode-cn.com/problems/maximum-product-of-three-numbers/">Maximum Product
 * of Three Numbers</a>
 * @since 2021-07-23
 */
public class Solution628 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maximumProduct(int[] nums) {
        int[] max = new int[]{-1000, -1000, -1000};
        int[] min = new int[]{1000, 1000};
        for (int num : nums) {
            if (num < min[0]) {
                min[1] = min[0];
                min[0] = num;
            } else if (num < min[1]) {
                min[1] = num;
            }
            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (num > max[2]) {
                max[2] = num;
            }
        }
        return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[0]);
    }
}
