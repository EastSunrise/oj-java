package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/multiply-strings/">43. Multiply Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution2
 * @see cn.kingen.oj.leetcode.problem.p0.Solution66
 * @see cn.kingen.oj.leetcode.problem.p0.Solution67
 * @see cn.kingen.oj.leetcode.problem.p400.Solution415
 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution43 {

    @Complexity(time = "O(m*n)", space = "O(1)")
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // the carry of last digit
        int m = num1.length(), n = num2.length(), carry = 0;
        StringBuilder res = new StringBuilder(m + n);
        // k: the sum of the indices of the two chosen digits
        for (int k = m + n - 2; k >= 0; k--) {
            int i = Math.max(0, k - n + 1);
            int iLen = Math.min(k + 1, m);
            for (int j = k - i; i < iLen; i++, j--) {
                carry += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
            res.append(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}