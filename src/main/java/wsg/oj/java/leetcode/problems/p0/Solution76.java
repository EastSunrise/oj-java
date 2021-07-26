package wsg.oj.java.leetcode.problems.p0;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution209;
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
     * @complexity T=O(Cm+n), C=52
     * @complexity S=O(C+n)
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
        // stores indices of chars that are contained in t
        Deque<Integer> queue = new LinkedList<>();
        Map<Character, Integer> window = new HashMap<>(52);
        String res = "";
        int i = 0, min = Integer.MAX_VALUE;
        while (i < m) {
            do {
                char ch = s.charAt(i);
                if (base.containsKey(ch)) {
                    window.put(ch, window.getOrDefault(ch, 0) + 1);
                    queue.addLast(i);
                    if (contain(window, base)) {
                        break;
                    }
                }
            } while (++i < m);
            if (i == m) {
                break;
            }
            int begin;
            do {
                begin = queue.removeFirst();
                window.put(s.charAt(begin), window.get(s.charAt(begin)) - 1);
            } while (contain(window, base));
            // find a substring s[begin,i] that contains t
            int len = i - begin + 1;
            if (len < min) {
                min = len;
                res = s.substring(begin, i + 1);
            }
            i++;
        }
        return res;
    }

    private boolean contain(Map<Character, Integer> window, Map<Character, Integer> base) {
        for (Map.Entry<Character, Integer> entry : base.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
