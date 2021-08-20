package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符  LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/">第一个只出现一次的字符
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer50 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(26)
     */
    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (counts[ch - 'a'] == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
