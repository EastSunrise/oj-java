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

    @Complexity(time = "O(n)", space = "O(1)")
    public long maximumOr(int[] nums, int k) {
        int or = 0, multiOr = 0;
        for (int num : nums) {
            multiOr |= or & num;
            or |= num;
        }

        long ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, or ^ num | multiOr | (long) num << k);
        }
        return ans;
    }
}