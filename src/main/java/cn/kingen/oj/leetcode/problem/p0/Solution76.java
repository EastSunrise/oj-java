package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">76. Minimum Window Substring</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution30
 * @see cn.kingen.oj.leetcode.problem.p200.Solution209
 * @see cn.kingen.oj.leetcode.problem.p200.Solution239
 * @see cn.kingen.oj.leetcode.problem.p500.Solution567
 * @see cn.kingen.oj.leetcode.problem.p700.Solution727
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.HARD
)
public class Solution76 {

    @Complexity(time = "O(m+n)", space = "O(C)", note = "C is the number of distinct characters in t")
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> freq = new HashMap<>(52);
        for (int i = 0; i < n; i++) {
            freq.merge(t.charAt(i), 1, Integer::sum);
        }

        int size = freq.size(), start = 0, end = m + 1;
        for (int i = 0, j = 0; j < m; j++) {
            char ch = s.charAt(j);
            if (!freq.containsKey(ch)) {
                continue;
            }
            if (freq.merge(ch, 1, (old, delta) -> old - delta) == 0) { // current character is all covered
                size--;
            }
            if (size == 0) { // all characters are covered, all counts <= 0
                for (; i <= j; i++) { // remove redundant characters
                    ch = s.charAt(i);
                    if (freq.containsKey(ch)) {
                        int cnt = freq.get(ch);
                        if (cnt < 0) {
                            freq.put(ch, cnt + 1);
                        } else { // cannot remove it if the char is covered in window exactly
                            break;
                        }
                    }
                }
                // all characters are covered within s[i,j]
                if (j - i + 1 < end - start) {
                    start = i;
                    end = j + 1;
                }
            }
        }
        return end > m ? "" : s.substring(start, end);
    }
}