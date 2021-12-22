package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern (Easy)
 *
 * @author Kingen
 * @see Solution205
 * @see Solution291
 * @see <a href="https://leetcode-cn.com/problems/word-pattern/">Word Pattern</a>
 */
class Solution290 implements Solution {

    /**
     * Builds maps to match a pattern.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] words = s.split(" ");
        if (n != words.length) {
            return false;
        }
        Map<Character, String> p2s = new HashMap<>(26);
        Map<String, Character> s2p = new HashMap<>(26);
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = p2s.put(ch, words[i]);
            if (word != null && !word.equals(words[i])) {
                return false;
            }
            Character prev = s2p.put(words[i], ch);
            if (prev != null && !prev.equals(ch)) {
                return false;
            }
        }
        return true;
    }
}
