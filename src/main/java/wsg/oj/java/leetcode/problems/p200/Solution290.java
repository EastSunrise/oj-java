package wsg.oj.java.leetcode.problems.p200;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 290. Word Pattern (Easy)
 *
 * @author Kingen
 * @see Solution205
 * @see Solution291
 * @see <a href="https://leetcode-cn.com/problems/word-pattern/">Word Pattern</a>
 * @since 2021-07-13
 */
class Solution290 implements Solution {

    /**
     * Builds maps to match a pattern.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>(26);
        Map<String, Character> s2p = new HashMap<>(26);
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            String origin = p2s.put(chars[i], words[i]);
            Character c = s2p.put(words[i], chars[i]);
            if (origin != null && !origin.equals(words[i])) {
                return false;
            }
            if (c != null && !c.equals(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
