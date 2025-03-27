package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-to-make-all-characters-equal/">2712. Minimum Cost to Make All
 * Characters Equal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution926
 */
@Question(
    tags = {Tag.GREEDY, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM,
    date = "2025-03-27"
)
public class Solution2712 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long minimumCost(String s) {
        int n = s.length();
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }
}