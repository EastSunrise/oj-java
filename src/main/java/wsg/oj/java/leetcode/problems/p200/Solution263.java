package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 263. Ugly Number (Easy)
 *
 * @author Kingen
 * @see Solution202
 * @see Solution204
 * @see Solution264
 * @see <a href="https://leetcode-cn.com/problems/ugly-number/">Ugly Number</a>
 * @since 2021-07-13
 */
class Solution263 implements Solution {

    /**
     * @complexity T=O(ijk), n=2^i*3^j*5^k*p
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
