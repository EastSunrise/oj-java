package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 64. 求1+2+…+n LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/qiu-12n-lcof/">求1+2+…+n LCOF</a>
 */
public class Offer64 implements Solution {

    public int sumNums(int n) {
        return ((int) (Math.pow(n, 2)) + n) >> 1;
    }
}
