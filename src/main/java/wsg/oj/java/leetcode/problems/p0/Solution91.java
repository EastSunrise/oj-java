package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution639;

/**
 * 91. Decode Ways (Medium)
 *
 * @author Kingen
 * @see Solution639
 * @see <a href="https://leetcode-cn.com/problems/decode-ways/">Decode Ways</a>
 * @since 2021-07-11
 */
public class Solution91 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int numDecodings(String s) {
        int n = s.length();
        // dp[i]: the number of decodes of s[0,i-1]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            char cur = s.charAt(i - 1);
            if (cur != '0') {
                dp[i] += dp[i - 1];
            }
            char prev = s.charAt(i - 2);
            if (prev == '1' || (prev == '2' && cur <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
