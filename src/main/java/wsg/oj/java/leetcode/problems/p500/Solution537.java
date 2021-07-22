package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 537. Complex Number Multiplication (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/complex-number-multiplication/">Complex Number
 * Multiplication</a>
 * @since 2021-07-20
 */
class Solution537 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String complexNumberMultiply(String num1, String num2) {
        int i1 = num1.indexOf('+');
        int real1 = Integer.parseInt(num1.substring(0, i1));
        int imaginary1 = Integer.parseInt(num1.substring(i1 + 1, num1.length() - 1));
        int i2 = num2.indexOf('+');
        int real2 = Integer.parseInt(num2.substring(0, i2));
        int imaginary2 = Integer.parseInt(num2.substring(i2 + 1, num2.length() - 1));
        int real = real1 * real2 - imaginary1 * imaginary2;
        int imaginary = real1 * imaginary2 + real2 * imaginary1;
        return new StringBuilder()
            .append(real).append('+').append(imaginary).append('i').toString();
    }
}
