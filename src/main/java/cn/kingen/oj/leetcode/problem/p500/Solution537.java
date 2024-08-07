package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/complex-number-multiplication/">537. Complex Number Multiplication</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution537 {

    @Complexity(time = "O(1)", space = "O(1)")
    public String complexNumberMultiply(String num1, String num2) {
        int i1 = num1.indexOf('+');
        int real1 = Integer.parseInt(num1.substring(0, i1));
        int imaginary1 = Integer.parseInt(num1.substring(i1 + 1, num1.length() - 1));
        int i2 = num2.indexOf('+');
        int real2 = Integer.parseInt(num2.substring(0, i2));
        int imaginary2 = Integer.parseInt(num2.substring(i2 + 1, num2.length() - 1));
        int real = real1 * real2 - imaginary1 * imaginary2;
        int imaginary = real1 * imaginary2 + real2 * imaginary1;
        return real + "+" + imaginary + "i";
    }
}