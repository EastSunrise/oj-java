package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 400. Nth Digit (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/nth-digit/">Nth Digit</a>
 * @since 2021-07-06
 */
class Solution400 implements Solution {

    /**
     * @complexity T=O(lgn)
     * @complexity S=O(1)
     */
    public int findNthDigit(int n) {
        long base = 1, count = 9, digits = 9, first = 1;
        while (n > digits) {
            n -= digits;
            base++;
            count *= 10;
            digits = count * base;
            first *= 10;
        }
        n--;
        int target = (int) (first + n / base);
        int pos = (int) (n % base);
        return String.valueOf(target).charAt(pos) - '0';
    }
}
