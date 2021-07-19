package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution42;
import wsg.oj.java.leetcode.problems.p100.Solution152;

/**
 * 238. Product of Array Except Self (Medium)
 *
 * @author Kingen
 * @see Solution42
 * @see Solution152
 * @see Solution265
 * @see <a href="https://leetcode-cn.com/problems/product-of-array-except-self/">Product of Array
 * Except Self</a>
 * @since 2021-07-13
 */
public class Solution238 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // calculate the product of nums[0,i-1]
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // calculate the product of nums[i+1,len)
        int product = 1;
        for (int i = len - 2; i >= 0; i--) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        return res;
    }
}