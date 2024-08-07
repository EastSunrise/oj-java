package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution152
 * @see cn.kingen.oj.leetcode.problem.p300.Solution325
 * @see cn.kingen.oj.leetcode.problem.p500.Solution560
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1099
 */
@Question(
        tags = {Tag.ARRAY, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution713 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int product = 1, count = 0;
        for (int i = 0, j = 0; j < n; j++) {
            product *= nums[j];
            while (product >= k) {
                product /= nums[i++];
            }
            // the subarray that ends with nums[j]
            count += j - i + 1;
        }
        return count;
    }
}