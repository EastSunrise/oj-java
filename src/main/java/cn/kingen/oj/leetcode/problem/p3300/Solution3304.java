package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i/">3304. Find the K-th Character in String Game I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution848

 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.RECURSION, Tag.MATH, Tag.SIMULATION},
        difficulty = Difficulty.EASY,
        contest = 417
)
public class Solution3304 {

    @Complexity(time = "O(1)", space = "O(1)")
    public char kthCharacter(int k) {
        return (char) ('a' + Integer.bitCount(k) - 1 + Integer.numberOfTrailingZeros(k));
    }
}