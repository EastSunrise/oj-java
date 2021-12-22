package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p600.Solution691;

/**
 * 383. Ransom Note (Easy)
 *
 * @author Kingen
 * @see Solution691
 * @see <a href="https://leetcode-cn.com/problems/ransom-note/">Ransom Note</a>
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
