package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution42
 * @see cn.kingen.oj.leetcode.problem.p100.Solution152
 * @see cn.kingen.oj.leetcode.problem.p200.Solution265
 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution238 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) { // calculate the product of nums[0,i-1]
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = n - 2; i >= 0; i--) { // calculate the product of nums[i+1,n)
            product *= nums[i + 1];
            ans[i] *= product;
        }
        return ans;
    }
}