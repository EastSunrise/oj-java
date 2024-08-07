package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/hamming-distance/">461. Hamming Distance</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 * @see cn.kingen.oj.leetcode.problem.p400.Solution477
 */
@Question(
        tags = {Tag.BIT_MANIPULATION},
        difficulty = Difficulty.EASY
)
public class Solution461 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}