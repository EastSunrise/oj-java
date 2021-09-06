package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 22. 黑白方格画 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ccw6C7/">黑白方格画</a>
 * @since 2021-07-28
 */
public class Lcp22 implements Solution {

    /**
     * @complexity T=O(n+k/n)
     * @complexity S=O(n)
     */
    public int paintingPlan(int n, int k) {
        if (k == n * n) {
            return 1;
        }
        int[] coefficients = binomial(n);
        int rmax = k / n, cnt = 0;
        for (int r = 0; r <= rmax; r++) {
            int height = n - r, black = k - n * r;
            if (black % height == 0) {
                int c = black / height;
                cnt += coefficients[r] * coefficients[c];
            }
        }
        return cnt;
    }

    private int[] binomial(int n) {
        int[] coefficients = new int[n + 1];
        int mid = n / 2;
        coefficients[0] = coefficients[n] = 1;
        for (int i = 1; i <= mid; i++) {
            coefficients[i] = coefficients[i - 1] * (n - i + 1) / i;
            coefficients[n - i] = coefficients[i];
        }
        return coefficients;
    }
}
