package wsg.oj.java.leetcode.problems.p0;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution209;
import wsg.oj.java.leetcode.problems.p200.Solution239;
import wsg.oj.java.leetcode.problems.p500.Solution567;

/**
 * 76. Minimum Window Substring (HARD)
 *
 * @author Kingen
 * @see Solution30
 * @see Solution209
 * @see Solution239
 * @see Solution567
 * @see Solution632
 * @see Solution727
 * @see <a href="https://leetcode-cn.com/problems/minimum-window-substring/">Minimum Window
 * Substring</a>
 * @since 2021-07-19
 */
public class Solution76 implements Solution {

    /**
     * @complexity T=O(m+n)
     * @complexity S=O(C+n), C=52
     */
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> base = new HashMap<>(52);
        for (char ch : t.toCharArray()) {
            base.put(ch, base.getOrDefault(ch, 0) + 1);
        }

        int i = 0, start = 0, end = m + 1;
        int size = base.size();
        for (int j = 0; j < m; j++) {
            char ch = s.charAt(j);
            if (!base.containsKey(ch)) {
                continue;
            }
            if (base.put(ch, base.get(ch) - 1) == 1) {
                // a character is all covered
                size--;
            }
            if (size == 0) {
                // remove redundant characters
                while (true) {
                    ch = s.charAt(i);
                    if (!base.containsKey(ch)) {
                        // if the char is not contained in t
                        i++;
                    } else {
                        int cnt = base.get(ch);
                        if (cnt < 0) {
                            // if the count of the char is over that in t
                            base.put(ch, cnt + 1);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                // all characters of t are covered within s[i,j]
                if (j + 1 - i < end - start) {
                    start = i;
                    end = j + 1;
                }
            }
        }
        return end > m ? "" : s.substring(start, end);
    }
}
