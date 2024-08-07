package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-subarray/">152. Maximum Product Subarray</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution53
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p200.Solution238
 * @see cn.kingen.oj.leetcode.problem.p600.Solution628
 * @see cn.kingen.oj.leetcode.problem.p700.Solution713
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution152 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxProduct(int[] nums) {
        // max: the max product of the subarray that ends with nums[i]
        // min: the min product of the subarray that ends with nums[i]
        int max = 1, min = 1, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0) {
                max = Math.max(num, max * num);
                min = Math.min(num, min * num);
            } else {
                int tmp = max;
                max = Math.max(num, min * num);
                min = Math.min(num, tmp * num);
            }
            ans = Math.max(max, ans);
        }
        return ans;
    }
}