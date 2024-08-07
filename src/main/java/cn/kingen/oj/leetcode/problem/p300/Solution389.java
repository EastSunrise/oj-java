package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-difference/">389. Find the Difference</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution136
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution389 {

    @Complexity(time = "O(n)", space = "O(1)")
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            sum ^= s.charAt(i);
        }
        for (int i = 0, n = t.length(); i < n; i++) {
            sum ^= t.charAt(i);
        }
        return (char) sum;
    }
}