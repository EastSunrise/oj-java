package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/">2207. Maximize Number of Subsequences in a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1143
 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution2207 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        char a = pattern.charAt(0), b = pattern.charAt(1);
        long ans = 0;
        int aCnt = 0, bCnt = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (ch == b) {
                bCnt++;
                ans += aCnt;
            }
            if (ch == a) {
                aCnt++;
            }
        }
        return ans + Math.max(aCnt, bCnt);
    }
}