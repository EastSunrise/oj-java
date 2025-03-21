package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-or/">2680. Maximum OR</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GREEDY, Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-21"
)
public class Solution2680 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] prefixOr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixOr[i + 1] = prefixOr[i] | nums[i];
        }

        long ans = 0;
        int suffixOr = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = Math.max(ans, prefixOr[i] | ((long) nums[i] << k) | suffixOr);
            suffixOr |= nums[i];
        }
        return ans;
    }
}