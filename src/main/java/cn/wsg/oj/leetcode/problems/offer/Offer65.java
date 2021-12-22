package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 65. 不用加减乘除做加法 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/">不用加减乘除做加法
 * LCOF</a>
 */
public class Offer65 implements Solution {

    /**
     * @complexity T=O(32)
     * @complexity S=O(1)
     */
    public int add(int a, int b) {
        int sum = a, carry = b;
        while (carry != 0) {
            int tmp = (sum & carry) << 1;
            sum ^= carry;
            carry = tmp;
        }
        return sum;
    }
}
