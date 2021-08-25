package wsg.oj.java.leetcode.problems.p1700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1734. Decode XORed Permutation (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/decode-xored-permutation/">Decode XORed
 * Permutation</a>
 * @since 2021-07-27
 */
public class Solution1734 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int i = 1; i < n; i += 2) {
            xor ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = xor;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}
