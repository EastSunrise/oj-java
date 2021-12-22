package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">Minimum
 * Flips to Make a OR b Equal to c</a>
 */
public class Solution1318 implements Solution {

    /**
     * @complexity T=O(32)
     * @complexity S=O(1)
     */
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            if ((c & 1) == 1) {
                flips += 1 ^ ((a & 1) | (b & 1));
            } else {
                flips += (a & 1) + (b & 1);
            }
            a >>>= 1;
            b >>>= 1;
            c >>>= 1;
        }
        return flips;
    }
}
