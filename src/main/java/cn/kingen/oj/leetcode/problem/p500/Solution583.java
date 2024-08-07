package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.StringUtils.lcs;

/**
 * <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/">583. Delete Operation for Two Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution72
 * @see cn.kingen.oj.leetcode.problem.p700.Solution712
 */
@Question(
        tags = {Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution583 {

    @Complexity(time = "O(n*m)", space = "O(n*m)")
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcs(word1, word2);
    }
}