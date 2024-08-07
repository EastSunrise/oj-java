package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/add-without-plus-lcci/">面试题 17.01. Add Without Plus LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Interview01 {

    @Complexity(time = "O(log{b})", space = "O(1)")
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}