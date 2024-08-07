package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-i/">521. Longest Uncommon Subsequence I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution522
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution521 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}