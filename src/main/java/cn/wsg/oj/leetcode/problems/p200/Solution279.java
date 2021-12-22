package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 279. Perfect Squares (Medium)
 *
 * @author Kingen
 * @see Solution204
 * @see Solution264
 * @see <a href="https://leetcode-cn.com/problems/perfect-squares/">Perfect Squares</a>
 */
public class Solution279 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int base = 2, square = 4;
        for (int i = 2; i <= n; i++) {
            if (i == square) {
                dp[i] = 1;
                base++;
                square = base * base;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1, jj = 1; jj <= i; j++, jj = j * j) {
                    dp[i] = Math.min(dp[i], dp[i - jj] + 1);
                }
            }
        }
        return dp[n];
    }

    /**
     * Every natural number n can be represented as the sum of four integers squares.
     * <p>
     * If and only if n=(4^k)(8m+7), n can only be represented as the sum of four positive integers
     * squares.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem>Lagrange's
     * four-square theorem</a>
     */
    public int numSquares2(int n) {
        if (isSquare(n)) {
            return 1;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }
}
