package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.StringUtils.lcs;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/">1143. Longest Common Subsequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution516
 * @see cn.kingen.oj.leetcode.problem.p500.Solution583
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1092
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2207
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2565
 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1143 {

    @Complexity(time = "O(n*m)", space = "O(n*m)")
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2);
    }
}