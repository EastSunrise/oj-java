package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 46. 把数字翻译成字符串 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/">把数字翻译成字符串
 * LCOF</a>
 */
public class Offer46 implements Solution {

    public int translateNum(int num) {
        int[] digits = new int[11];
        int i = 11;
        while (num > 0) {
            digits[--i] = num % 10;
            num /= 10;
        }
        int prev = 1, cur = 1;
        while (++i < 11) {
            int code = digits[i - 1] * 10 + digits[i];
            if (code >= 10 && code < 26) {
                cur = prev + cur;
                prev = cur - prev;
            } else {
                prev = cur;
            }
        }
        return cur;
    }
}
