package wsg.oj.java.leetcode.problems.p700;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 748. Shortest Completing Word (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-completing-word/">Shortest Completing
 * Word</a>
 * @since 2021-07-26
 */
public class Solution748 implements Solution {

    /**
     * @complexity T=O(m+L), m=len(licensePlate), L=the total length of words
     * @complexity S=O(26*n), n=the size of words
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] counts = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                counts[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                counts[ch - 'A']++;
            }
        }
        String target = null;
        for (String word : words) {
            int[] copy = Arrays.copyOf(counts, 26);
            if (isCompleted(word, copy) && (target == null || word.length() < target.length())) {
                target = word;
            }
        }
        return target;
    }

    private boolean isCompleted(String word, int[] counts) {
        for (char c : word.toCharArray()) {
            counts[c - 'a']--;
            if (counts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
