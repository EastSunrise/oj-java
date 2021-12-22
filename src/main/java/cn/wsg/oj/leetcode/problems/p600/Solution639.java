package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution91;

/**
 * 639. Decode Ways II (HARD)
 *
 * @author Kingen
 * @see Solution91
 * @see <a href="https://leetcode-cn.com/problems/decode-ways-ii/">Decode Ways II</a>
 */
public class Solution639 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int numDecodings(String s) {
        int n = s.length();
        // dp[i]: the number of decodes of s[0,i-1]
        long[] dp = new long[n + 1];
        dp[0] = 1;
        char first = s.charAt(0);
        if (first == '*') {
            dp[1] = 9;
        } else if (first != '0') {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            char prev = s.charAt(i - 2);
            char cur = s.charAt(i - 1);
            if (cur == '*') {
                // '*' as '1'~'9'
                dp[i] += 9 * dp[i - 1];
            } else if (cur != '0') {
                // one of '1'~'9'
                dp[i] += dp[i - 1];
            }
            if (prev == '*') {
                if (cur == '*') {
                    // "**" as one of "11"~"26" except "20"
                    dp[i] += 15 * dp[i - 2];
                } else if (cur <= '6') {
                    // "*k" as "1k" or "2k", 0<=k<=6
                    dp[i] += 2 * dp[i - 2];
                } else {
                    // "*k" as "1k", 7<=k<=9
                    dp[i] += dp[i - 2];
                }
            } else if (prev == '1') {
                if (cur == '*') {
                    // "1*" as one of "11"~"19"
                    dp[i] += 9 * dp[i - 2];
                } else {
                    // one of "10"~"19"
                    dp[i] += dp[i - 2];
                }
            } else if (prev == '2') {
                if (cur == '*') {
                    // "2*" as one of "21"~"26"
                    dp[i] += 6 * dp[i - 2];
                } else if (cur <= '6') {
                    // one of "20"~"26"
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= MOD;
        }
        return (int) dp[n];
    }
}
