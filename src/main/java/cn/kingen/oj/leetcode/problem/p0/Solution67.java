package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/add-binary/">67. Add Binary</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution2
 * @see cn.kingen.oj.leetcode.problem.p0.Solution43
 * @see cn.kingen.oj.leetcode.problem.p0.Solution66
 * @see cn.kingen.oj.leetcode.problem.p900.Solution989
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.MATH, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution67 {

    @Complexity(time = "O(m+n)", space = "O(max{m,n})")
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int k = Math.max(i, j) + 1;
        char[] ans = new char[k + 1];
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
            ans[k--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        while (i >= 0) {
            int sum = a.charAt(i--) - '0' + carry;
            ans[k--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        while (j >= 0) {
            int sum = b.charAt(j--) - '0' + carry;
            ans[k--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        if (carry == 0) {
            return String.valueOf(ans, 1, ans.length - 1);
        }
        ans[0] = '1';
        return String.valueOf(ans);
    }
}