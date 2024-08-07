package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/unique-paths/">62. Unique Paths</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution63
 * @see cn.kingen.oj.leetcode.problem.p0.Solution64
 * @see cn.kingen.oj.leetcode.problem.p100.Solution174
 */
@Question(
        tags = {Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.COMBINATORICS},
        difficulty = Difficulty.MEDIUM
)
public class Solution62 {

    /**
     * Combination C(m+n-2,m-1).
     */
    @Complexity(time = "O(min{m,n})", space = "O(1)")
    public int uniquePaths(int m, int n) {
        long ans = 1;
        int i = Math.min(m, n) - 1, k = m + n - 2;
        for (int j = 0; j < i; j++) {
            ans *= k--;
        }
        while (i > 1) {
            ans /= i--;
        }
        return (int) ans;
    }
}