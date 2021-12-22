package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution76;
import cn.wsg.oj.leetcode.problems.p400.Solution438;
import java.util.Arrays;

/**
 * 567. Permutation in String (MEDIUM)
 *
 * @author Kingen
 * @see Solution76
 * @see Solution438
 * @see <a href="https://leetcode-cn.com/problems/permutation-in-string/">Permutation in String</a>
 */
public class Solution567 implements Solution {

    /**
     * @complexity T=O(m+n+26)
     * @complexity S=O(26)
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] counts = new int[26];
        for (char ch : s1.toCharArray()) {
            counts[ch - 'a']++;
        }
        int base = hash(counts);

        int[] window = new int[26];
        for (int i = 0; i < m - 1; i++) {
            window[s2.charAt(i) - 'a']++;
        }
        int hash = hash(window);
        for (int i = m - 1; i < n; i++) {
            int idx = s2.charAt(i) - 'a';
            hash += idx;
            window[idx]++;
            if (hash == base && Arrays.equals(counts, window)) {
                return true;
            }
            idx = s2.charAt(i - m + 1) - 'a';
            hash -= idx;
            window[idx]--;
        }
        return false;
    }
}
