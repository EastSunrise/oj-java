package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sum-of-square-numbers/">633. Sum of Square Numbers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution367
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2778
 */
@Question(
        tags = {Tag.MATH, Tag.TWO_POINTERS, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution633 {

    @Complexity(time = "O(sqrt(c))", space = "O(1)")
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int dif = b * b - c + a * a; // avoid overflow
            if (dif == 0) {
                return true;
            } else if (dif < 0) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}