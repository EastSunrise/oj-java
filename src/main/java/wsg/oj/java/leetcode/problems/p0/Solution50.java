package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 50. Pow(x, n) (Medium)
 *
 * @author Kingen
 * @see Solution69
 * @see Solution372
 * @see <a href="https://leetcode-cn.com/problems/powx-n/">Pow(x, n)</a>
 * @since 2021-07-11
 */
class Solution50 implements Solution {

    /**
     * Calculates bit by bit. Look to {@link Integer#MIN_VALUE}.
     *
     * @complexity T=O(b), b=binary length
     * @complexity S=O(b)
     */
    public double myPow(double x, int n) {
        return n >= 0 ? positivePow(x, n) : 1 / positivePow(x, -(n + 1)) / x;
    }

    private double positivePow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double res = positivePow(x, n >> 1);
        return (n & 1) == 0 ? res * res : res * res * x;
    }
}
