package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 91. Decode Ways (Medium)
 *
 * @author Kingen
 * @see Solution639
 * @see <a href="https://leetcode-cn.com/problems/decode-ways/">Decode Ways</a>
 * @since 2021-07-11
 */
class Solution91 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[0] = chars[0] == '0' ? 0 : 1;
        if (len == 1) {
            return dp[0];
        }

        if (chars[1] > '0') {
            dp[1] += dp[0];
        }
        if (chars[0] == '1' || (chars[0] == '2' && chars[1] <= '6')) {
            dp[1] += 1;
        }
        for (int i = 2; i < len; i++) {
            if (chars[i] > '0') {
                dp[i] += dp[i - 1];
            }
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}
