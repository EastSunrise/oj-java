package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 504. Base 7 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/base-7/">Base 7</a>
 * @since 2021-07-20
 */
class Solution504 implements Solution {

    /**
     * @complexity T=O(log_{7}{n})
     * @complexity S=O(log_{7}{n})
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int value = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % 7);
            value /= 7;
        }
        if (num < 0) {
            builder.append("-");
        }
        return builder.reverse().toString();
    }
}
