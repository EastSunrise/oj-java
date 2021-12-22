package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 2. Deep Dark Fraction (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/deep-dark-fraction/">Deep Dark Fraction</a>
 */
public class Lcp2 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[] fraction(int[] cont) {
        int n = cont.length;
        int numerator = 1, denominator = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = numerator;
            numerator = denominator;
            denominator = tmp;
            numerator += denominator * cont[i];
        }
        return new int[]{numerator, denominator};
    }
}
