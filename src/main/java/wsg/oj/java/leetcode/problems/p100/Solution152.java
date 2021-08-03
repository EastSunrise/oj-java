package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution53;
import wsg.oj.java.leetcode.problems.p200.Solution238;
import wsg.oj.java.leetcode.problems.p600.Solution628;
import wsg.oj.java.leetcode.problems.p700.Solution713;

/**
 * 152. Maximum Product Subarray (Medium)
 *
 * @author Kingen
 * @see Solution53
 * @see Solution198
 * @see Solution238
 * @see Solution628
 * @see Solution713
 * @see <a href="https://leetcode-cn.com/problems/maximum-product-subarray/">Maximum Product
 * Subarray</a>
 * @since 2021-07-12
 */
public class Solution152 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxProduct(int[] nums) {
        // max: the max product of the subarray that ends with nums[i]
        // min: the min product of the subarray that ends with nums[i]
        int max = nums[0], min = nums[0], res = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
