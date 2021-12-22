package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 953. Verifying an Alien Dictionary (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/verifying-an-alien-dictionary/">Verifying an Alien
 * Dictionary</a>
 */
public class Solution953 implements Solution {

    /**
     * @complexity T=O(L+26), L=the total length of all words
     * @complexity S=O(26)
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < 26; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compareAlienString(words[i - 1], words[i], dict) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compareAlienString(String s1, String s2, int[] dict) {
        int i = 0, len1 = s1.length(), len2 = s2.length();
        while (i < len1 && i < len2) {
            int comp = dict[s1.charAt(i) - 'a'] - dict[s2.charAt(i) - 'a'];
            if (comp != 0) {
                return comp;
            }
            i++;
        }
        return len1 - len2;
    }
}
