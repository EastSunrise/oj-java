package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 383. Ransom Note (Easy)
 *
 * @author Kingen
 * @see Solution691
 * @see <a href="https://leetcode-cn.com/problems/ransom-note/">Ransom Note</a>
 * @since 2021-07-13
 */
public class Solution383 implements Solution {

    /**
     * @complexity T=O(m+n)
     * @complexity S=O(26)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char ch : magazine.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (counts[ch - 'a'] == 0) {
                return false;
            } else {
                counts[ch - 'a']--;
            }
        }
        return true;
    }
}
