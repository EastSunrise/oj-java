package cn.kingen.oj.leetcode.problem.p1900;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;
import static cn.kingen.oj.leetcode.util.MathUtils.fastPow;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-good-numbers/">1922. Count Good Numbers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3400.Solution3405

 */
@Question(
    tags = {Tag.RECURSION, Tag.MATH},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-13"
)
public class Solution1922 {

    @Complexity(time = "O(log n)", space = "O(1)")
    public int countGoodNumbers(long n) {
        return (int) (fastPow(5L, (n + 1) >> 1, MOD) * fastPow(4L, n >> 1, MOD) % MOD);
    }
}