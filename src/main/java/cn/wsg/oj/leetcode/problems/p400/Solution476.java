package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 476. Number Complement (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-complement/">Number Complement</a>
 */
class Solution476 implements Solution {

    /**
     * @complexity T=O(b), b=bits of the number
     * @complexity S=O(1)
     */
    public int findComplement(int num) {
        int mask = 0;
        while (mask < num) {
            mask = mask * 2 + 1;
        }
        return num ^ mask;
    }
}
