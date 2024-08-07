package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">415. Add Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution2
 * @see cn.kingen.oj.leetcode.problem.p0.Solution43
 * @see cn.kingen.oj.leetcode.problem.p900.Solution989
 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution415 {

    @Complexity(time = "O(max(m, n))", space = "O(max(m, n))")
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        char[] ans = new char[Math.max(m, n) + 1];
        int i = num1.length() - 1, j = num2.length() - 1;
        int k = ans.length - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + carry;
            carry = sum / 10;
            ans[k--] = (char) (sum % 10 + '0');
        }
        if (j >= 0) { // choose the unfinished one
            num1 = num2;
            i = j;
        }
        while (i >= 0) {
            int sum = num1.charAt(i--) - '0' + carry;
            carry = sum / 10;
            ans[k--] = (char) (sum % 10 + '0');
        }
        if (carry == 0) {
            return String.valueOf(ans, 1, ans.length - 1);
        }
        ans[k] = (char) (carry + '0');
        return new String(ans);
    }
}