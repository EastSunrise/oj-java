package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break (Medium)
 *
 * @author Kingen
 * @see Solution140
 * @see <a href="https://leetcode-cn.com/problems/word-break/">Word Break</a>
 */
class Solution139 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_N
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        // dp[i]: whether the substring s[0,i) can be broken to dict
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            // split s[0,i) into s[0,j)+s[j,i)
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
