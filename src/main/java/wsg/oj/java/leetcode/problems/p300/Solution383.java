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
class Solution383 implements Solution {

    /**
     * @complexity T=O(m+n)
     * @complexity S=O(26)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        char[] ms = magazine.toCharArray();
        for (char ch : ms) {
            counts[ch - 'a']++;
        }
        char[] rs = ransomNote.toCharArray();
        for (char ch : rs) {
            if (counts[ch - 'a'] == 0) {
                return false;
            } else {
                counts[ch - 'a']--;
            }
        }
        return true;
    }
}
