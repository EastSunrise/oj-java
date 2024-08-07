package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/powx-n/">50. Pow(x, n)</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution69
 * @see cn.kingen.oj.leetcode.problem.p300.Solution372
 */
@Question(
        tags = {Tag.RECURSION, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution50 {

    @Complexity(time = "O(C)", space = "O(C)", note = "C is binary length")
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            // avoid overflow if n=Integer.MIN_VALUE
            return 1.0 / myPow(x, -(n + 1)) / x;
        }
        double sqrt = myPow(x, n >> 1);
        return (n & 1) == 0 ? sqrt * sqrt : sqrt * sqrt * x;
    }
}