package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-lcci/">面试题 16.07. Maximum LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.BRAINTEASER, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Interview07 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int maximum(int a, int b) {
        long diff = (long) a - b;
        int sign = (int) (diff >>> 63); // 1 if a < b, 0 if a >= b
        return (1 - sign) * a + sign * b;
    }
}