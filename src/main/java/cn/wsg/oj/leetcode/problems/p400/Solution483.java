package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 483. Smallest Good Base (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/smallest-good-base/">Smallest Good Base</a>
 */
public class Solution483 implements Solution {

    /**
     * Solves the equation: (k^i-1)/(k-1)=n. n≡1(mod k).
     */
    public String smallestGoodBase(String s) {
        long n = Long.parseLong(s);
        int mMax = (int) Math.floor(Math.log(n) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(n, 1.0 / m);
            long tmp = n;
            while (tmp % k == 1) {
                tmp = tmp / k;
            }
            if (tmp == 0) {
                return Integer.toString(k);
            }
        }
        return Long.toString(n - 1);
    }
}
