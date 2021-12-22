package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.leetcode.problems.base.StringSolution;
import cn.wsg.oj.leetcode.problems.p0.Solution72;
import cn.wsg.oj.leetcode.problems.p1100.Solution1143;
import cn.wsg.oj.leetcode.problems.p700.Solution712;

/**
 * 583. Delete Operation for Two Strings (MEDIUM)
 *
 * @author Kingen
 * @see Solution72
 * @see Solution712
 * @see Solution1143
 * @see <a href="https://leetcode-cn.com/problems/delete-operation-for-two-strings/">Delete
 * Operation for Two Strings</a>
 */
public class Solution583 implements StringSolution {

    /**
     * Calculates the longest common subsequence of the two words.
     *
     * @see #lcs(String, String)
     */
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcs(word1, word2);
    }
}
