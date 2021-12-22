package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words (HARD)
 *
 * @author Kingen
 * @see Solution76
 * @see <a href="https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/">Substring
 * with Concatenation of All Words</a>
 */
public class Solution30 implements Solution {

    /**
     * @complexity T=O(2m-nl), m=len(s), n=len(words), l=len(word[i])
     * @complexity S=O(n)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, len = words[0].length(), total = n * len;
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>(16);
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            int left = i, right = left + total;
            if (right <= s.length()) {
                Map<String, Integer> window = new HashMap<>(16);
                for (int j = left; j < right; j += len) {
                    String word = s.substring(j, j + len);
                    window.put(word, window.getOrDefault(word, 0) + 1);
                }
                while (true) {
                    if (matches(dict, window)) {
                        res.add(left);
                    }
                    right += len;
                    if (right > s.length()) {
                        break;
                    }
                    String first = s.substring(left, left + len);
                    int count = window.get(first);
                    if (count == 1) {
                        window.remove(first);
                    } else {
                        window.put(first, count - 1);
                    }
                    left += len;
                    String last = s.substring(right - len, right);
                    window.put(last, window.getOrDefault(last, 0) + 1);
                }
            }
        }
        return res;
    }

    private boolean matches(Map<String, Integer> dict, Map<String, Integer> window) {
        if (dict.size() != window.size()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            Integer count = window.get(entry.getKey());
            if (count == null || !count.equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
