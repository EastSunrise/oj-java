package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/palindromic-substrings/">647. Palindromic Substrings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution5
 * @see cn.kingen.oj.leetcode.problem.p500.Solution516
 * @see cn.kingen.oj.leetcode.problem.p600.Solution647
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution647 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            // center is s[i]
            int low = i - 1, high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            ans += high - i;

            // center is s[i-1], s[i]
            low = i - 1;
            high = i;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            ans += high - i;
        }
        return ans;
    }
}