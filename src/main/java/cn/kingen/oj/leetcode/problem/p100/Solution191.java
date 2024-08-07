package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/">191. Number of 1 Bits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution190
 * @see cn.kingen.oj.leetcode.problem.p200.Solution231
 * @see cn.kingen.oj.leetcode.problem.p300.Solution338
 * @see cn.kingen.oj.leetcode.problem.p400.Solution401
 * @see cn.kingen.oj.leetcode.problem.p400.Solution461
 * @see cn.kingen.oj.leetcode.problem.p600.Solution693
 * @see cn.kingen.oj.leetcode.problem.p700.Solution762
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.DIVIDE_AND_CONQUER},
        difficulty = Difficulty.EASY
)
public class Solution191 {

    @Complexity(time = "O(C)", space = "O(1)", note = "C is 32")
    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; i++) {
            weight += n & 1;
            n >>= 1;
        }
        return weight;
    }
}