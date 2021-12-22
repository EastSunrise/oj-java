package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution65;

/**
 * 剑指 Offer 20. 表示数值的字符串 LCOF (MEDIUM)
 * <p>
 * todo DFA
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/">表示数值的字符串
 * LCOF</a>
 */
public class Offer20 extends Solution65 implements Solution {

    @Override
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        return super.isNumber(s);
    }
}
