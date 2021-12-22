package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution42;
import cn.wsg.oj.leetcode.problems.p100.Solution152;

/**
 * 238. Product of Array Except Self (Medium)
 *
 * @author Kingen
 * @see Solution42
 * @see Solution152
 * @see Solution265
 * @see <a href="https://leetcode-cn.com/problems/product-of-array-except-self/">Product of Array
 * Except Self</a>
 */
public class Solution238 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // calculate the product of nums[0,i-1]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // calculate the product of nums[i+1,n)
        int product = 1;
        for (int i = n - 2; i >= 0; i--) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        return res;
    }
}
