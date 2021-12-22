package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 423. Reconstruct Original Digits from English (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/">Reconstruct
 * Original Digits from English</a>
 */
class Solution423 implements Solution {

    /**
     * @complexity T=O(n+10)
     * @complexity S=O(26+10)
     */
    public String originalDigits(String s) {
        int[] letters = new int[26];
        for (char ch : s.toCharArray()) {
            letters[ch - 'a']++;
        }
        int[] counts = new int[10];
        counts[0] = letters['z' - 'a'];
        counts[2] = letters['w' - 'a'];
        counts[8] = letters['g' - 'a'];
        counts[6] = letters['x' - 'a'];
        counts[3] = letters['t' - 'a'] - counts[2] - counts[8];
        counts[4] = letters['r' - 'a'] - counts[3] - counts[0];
        counts[7] = letters['s' - 'a'] - counts[6];
        counts[1] = letters['o' - 'a'] - counts[4] - counts[2] - counts[0];
        counts[5] = letters['v' - 'a'] - counts[7];
        counts[9] = letters['i' - 'a'] - counts[8] - counts[6] - counts[5];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            res.append(String.valueOf(i).repeat(counts[i]));
        }
        return res.toString();
    }
}
