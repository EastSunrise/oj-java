package wsg.oj.java.leetcode.problems.p1400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/">Probability
 * of a Two Boxes Having The Same Number of Distinct Balls</a>
 * @since 2021-07-27
 */
public class Solution1467 implements Solution {

    long[][] comb;

    /**
     * @see #DFS
     */
    public double getProbability(int[] balls) {
        int n = 0;
        for (int ball : balls) {
            n += ball;
        }
        n /= 2;

        calcCombinationNumbers();
        long cnt = dfs(balls, balls.length - 1, 0, 0, 0, 0, n);
        // the total is C(2n,n)
        double total = 1;
        for (int i = 0; i < n; i++) {
            total *= 2 * n - i;
            total /= i + 1;
        }
        return cnt / total;
    }

    private long dfs(int[] balls, int i, int num1, int num2, int color1, int color2, int n) {
        if (num1 > n || num2 > n || Math.abs(color1 - color2) > i + 1) {
            // prune if any box has more than n balls
            // or if the difference of the two colors is too mush to be made up with left balls
            return 0;
        }
        if (i == -1) {
            return 1;
        }
        int m = balls[i--];
        long cnt = 0;
        for (int j = 0; j <= m; j++) {
            // put j balls of this color into box 1 and m-j balls into box 2
            cnt += dfs(balls, i, num1 + j, num2 + m - j,
                j == 0 ? color1 : color1 + 1, j == m ? color2 : color2 + 1, n) * comb[m][j];
        }
        return cnt;
    }

    private void calcCombinationNumbers() {
        comb = new long[7][7];
        comb[1][0] = comb[1][1] = 1;
        for (int i = 2; i < 7; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                // C(i,j)
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
    }
}
