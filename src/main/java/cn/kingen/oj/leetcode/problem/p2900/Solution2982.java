package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/">2982. Find Longest Special Substring That Occurs Thrice II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution3
 * @see cn.kingen.oj.leetcode.problem.p300.Solution395
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.BINARY_SEARCH, Tag.COUNTING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution2982 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is the number of distinct characters")
    public int maximumLength(String s) {
        int n = s.length();
        // maxStat[k]: the number of occurrences of the character k that has max length
        int[] maxStat = new int[26], secondStat = new int[26];
        int max = 0;
        for (int i = 0; i < n; ) {
            char ch = s.charAt(i);
            int j = i + 1;
            while (j < n && s.charAt(j) == ch) {
                j++;
            }
            int len = j - i, k = ch - 'a';
            if (len > max) {
                if (len > max + 1) {
                    Arrays.fill(secondStat, 0);
                } else {
                    System.arraycopy(maxStat, 0, secondStat, 0, 26);
                }
                Arrays.fill(maxStat, 0);
                maxStat[k] = 1;
                max = len;
            } else if (len == max) {
                maxStat[k]++;
            } else if (len == max - 1) {
                secondStat[k]++;
            }
            i = j;
        }
        for (int i = 0; i < 26; i++) {
            if (maxStat[i] >= 3) {
                return max;
            }
            // split one longest string into two shorter strings
            // for example: "aaaa" to "aaa" and "aaa"
            secondStat[i] += 2 * maxStat[i];
        }
        if (max > 1) {
            for (int i = 0; i < 26; i++) {
                if (secondStat[i] >= 3) {
                    return max - 1;
                }
            }
        }
        return max > 2 ? max - 2 : -1;
    }
}