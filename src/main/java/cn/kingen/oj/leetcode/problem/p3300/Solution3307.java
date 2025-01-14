package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-th-character-in-string-game-ii/">3307. Find the K-th Character in String Game II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution848
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.RECURSION, Tag.MATH},
        difficulty = Difficulty.HARD,
        contest = 417
)
public class Solution3307 {

    @Complexity(time = "O(log(k))", space = "O(1)")
    public char kthCharacter(long k, int[] operations) {
        k--;
        int change = 0;
        for (int i = 0; k > 0; i++) {
            change += (int) (k & 1 & operations[i]); // related 2nd operation
            k >>= 1;
        }
        return (char) ('a' + change % 26);
    }
}