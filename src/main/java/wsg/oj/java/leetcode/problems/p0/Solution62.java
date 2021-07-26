package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 62. Unique Paths (Medium)
 *
 * @author Kingen
 * @see Solution63
 * @see Solution64
 * @see Solution174
 * @see <a href="https://leetcode-cn.com/problems/unique-paths/">Unique Paths</a>
 * @since 2021-07-11
 */
public class Solution62 implements Solution {

    /**
     * C(m+n-2,m-1).
     *
     * @complexity T=O(min(m,n))
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int uniquePaths(int m, int n) {
        // combinatorial number: C(m-1, m+n-2)
        long res = 1;
        int i = Math.min(m, n) - 1, k = m + n - 2;
        for (int j = 0; j < i; j++) {
            res *= k--;
        }
        while (i > 1) {
            res /= i--;
        }
        return (int) res;
    }
}
