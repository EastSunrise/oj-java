package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-even-and-odd-bits/">2595. Number of Even and Odd Bits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1295

 */
@Question(
        tags = {Tag.BIT_MANIPULATION},
        difficulty = Difficulty.EASY,
        date = "2025-02-20"
)
public class Solution2595 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int[] evenOddBit(int n) {
        return new int[]{
                Integer.bitCount(n & 0x55555555),
                Integer.bitCount(n & 0xaaaaaaaa)
        };
    }
}