package cn.kingen.oj.leetcode.problem.ch08;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/three-steps-problem-lcci/">面试题 08.01. Three Steps Problem LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MEMOIZATION, Tag.MATH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.EASY
)
public class Interview01 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int dp0 = 1, dp1 = 2, dp2 = 4, dp;
        for (int i = 3; i < n; i++) {
            dp = ((dp2 + dp1) % MOD + dp0) % MOD;
            dp0 = dp1;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp2;
    }
}