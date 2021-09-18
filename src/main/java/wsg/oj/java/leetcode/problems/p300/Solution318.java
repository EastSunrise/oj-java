package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 318. Maximum Product of Word Lengths (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-product-of-word-lengths/">Maximum Product
 * of Word Lengths</a>
 * @since 2021-07-13
 */
public class Solution318 implements Solution {

    /**
     * Uses a 26-bits integer as a word's hash.
     *
     * @complexity T=O(n^2+Cn), C=26
     * @complexity S=O(n)
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] hashes = new int[n];
        for (int i = 0; i < n; i++) {
            for (char ch : words[i].toCharArray()) {
                hashes[i] |= 1 << (ch - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if ((hashes[i] & hashes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
