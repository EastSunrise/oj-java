package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 58-II. 左旋转字符串 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">左旋转字符串 LCOF</a>
 */
public class Offer58II implements Solution {

    public String reverseLeftWords(String s, int n) {
        n %= s.length();
        return s.substring(n) + s.substring(0, n);
    }
}
