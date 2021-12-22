package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution198;
import cn.wsg.oj.leetcode.problems.p200.Solution213;
import cn.wsg.oj.leetcode.problems.p400.Solution474;

/**
 * 600. Non-negative Integers without Consecutive Ones (HARD)
 *
 * @author Kingen
 * @see Solution198
 * @see Solution213
 * @see Solution474
 * @see <a href="https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/">Non-negative
 * Integers without Consecutive Ones</a>
 */
public class Solution600 implements Solution {

    /**
     * @complexity T=O(32)
     * @complexity S=O(32)
     */
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int prev = 0, cnt = 0, i = 29;
        while (i >= 0) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                cnt += dp[i + 1];
                if (prev == 1) {
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }
            i--;
        }
        return i < 0 ? cnt + 1 : cnt;
    }
}
