package cn.wsg.oj.leetcode.problems.p1100;

import cn.wsg.oj.leetcode.problems.base.StringSolution;
import cn.wsg.oj.leetcode.problems.p500.Solution516;
import cn.wsg.oj.leetcode.problems.p500.Solution583;

/**
 * 1143. Longest Common Subsequence (MEDIUM)
 *
 * @author Kingen
 * @see Solution516
 * @see Solution583
 * @see Solution1092
 * @see <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">Longest Common
 * Subsequence</a>
 */
public class Solution1143 implements StringSolution {

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2);
    }
}
