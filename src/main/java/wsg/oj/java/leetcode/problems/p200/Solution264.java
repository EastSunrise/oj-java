package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution23;
import wsg.oj.java.leetcode.problems.p300.Solution313;

/**
 * 264. Ugly Number II (Medium)
 *
 * @author Kingen
 * @see Solution23
 * @see Solution204
 * @see Solution263
 * @see Solution279
 * @see Solution313
 * @see Solution1201
 * @see <a href="https://leetcode-cn.com/problems/ugly-number-ii/">Ugly Number II</a>
 * @since 2021-07-13
 */
public class Solution264 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num2 = 2 * dp[i2], num3 = 3 * dp[i3], num5 = 5 * dp[i5];
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                i2++;
            }
            if (dp[i] == num3) {
                i3++;
            }
            if (dp[i] == num5) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
