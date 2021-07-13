package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution49;

/**
 * 242. Valid Anagram (Easy)
 *
 * @author Kingen
 * @see Solution49
 * @see Solution266
 * @see Solution438
 * @see <a href="https://leetcode-cn.com/problems/valid-anagram/">Valid Anagram</a>
 * @since 2021-07-13
 */
public class Solution242 implements Solution {

    /**
     * @complexity S=T(26)
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            int i = ch - 'a';
            if (count[i] == 0) {
                return false;
            }
            count[i]--;
        }
        return true;
    }
}
