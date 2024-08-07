package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/distribute-candies-among-children-i/">2928. Distribute Candies Among Children I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1692
 */
@Question(
        tags = {Tag.MATH, Tag.COMBINATORICS, Tag.ENUMERATION},
        difficulty = Difficulty.EASY
)
public class Solution2928 {

    @Complexity(time = "O(min{n,limit})", space = "O(1)")
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int i = Math.max(0, n - 2 * limit); i <= limit && i <= n; i++) {
            int remaining = n - i;
            ans += Math.min(remaining, limit) - Math.max(0, remaining - limit) + 1;
        }
        return ans;
    }
}