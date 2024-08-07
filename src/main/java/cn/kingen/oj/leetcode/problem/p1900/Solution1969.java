package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;
import static cn.kingen.oj.leetcode.util.MathUtils.fastPow;

/**
 * <a href="https://leetcode.cn/problems/minimum-non-zero-product-of-the-array-elements/">1969. Minimum Non-Zero Product of the Array Elements</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.RECURSION, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution1969 {

    /**
     * The minimum is (2^p-2)^(2^(p-1)-1)*(2^p-1).
     */
    @Complexity(time = "O(p)", space = "O(1)")
    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long x = fastPow(2L, p);
        long y = (1L << (p - 1)) - 1;
        return (int) (fastPow(x - 2, y) * (x - 1) % MOD);
    }
}