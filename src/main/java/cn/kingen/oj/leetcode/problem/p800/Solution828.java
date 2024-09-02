package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/">828. Count Unique Characters of All Substrings of a Given String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2262
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution828 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is the size of charset")
    public int uniqueLetterString(String s) {
        int n = s.length();
        // the indices of previous character in the string
        int[] pp = new int[26], p = new int[26];
        Arrays.fill(pp, -1);
        Arrays.fill(p, -1);
        // dp: the count of unique letters of substrings ending with s[i]
        int ans = 0, dp = 0;
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'A';
            dp += i - 2 * p[ch] + pp[ch];
            ans += dp;
            pp[ch] = p[ch];
            p[ch] = i;
        }
        return ans;
    }
}