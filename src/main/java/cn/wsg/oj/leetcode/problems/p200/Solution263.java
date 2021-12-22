package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 263. Ugly Number (Easy)
 *
 * @author Kingen
 * @see Solution202
 * @see Solution204
 * @see Solution264
 * @see <a href="https://leetcode-cn.com/problems/ugly-number/">Ugly Number</a>
 */
public class Solution263 implements Solution {

    /**
     * @complexity T=O(ijk), n=2^i*3^j*5^k*p
     * @see Complexity#SPACE_CONSTANT
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
