package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/reverse-bits/">190. Reverse Bits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution7
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.DIVIDE_AND_CONQUER},
        difficulty = Difficulty.EASY
)
public class Solution190 {

    @Complexity(time = "O(C)", space = "O(1)", note = "C is 32")
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n >>>= 1;
        }
        return ans;
    }
}