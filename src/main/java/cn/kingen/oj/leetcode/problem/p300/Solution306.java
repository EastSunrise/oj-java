package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/additive-number/">306. Additive Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution842
 */
@Question(
        tags = {Tag.STRING, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution306 {

    @Complexity(time = "O(n^3)", space = "O(n)")
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n <= 2) {
            return false;
        }
        char[] chars = num.toCharArray();
        for (int b = 1; b < n; b++) {
            for (int c = b + 1; c < n; c++) {
                if (isAdditiveNumber(chars, 0, b, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param a start index of the first number
     * @param b start index of the second number
     * @param c start index of the third number
     */
    private boolean isAdditiveNumber(char[] chars, int a, int b, int c) {
        if ((chars[a] == '0' && b - a > 1) || (chars[b] == '0' && c - b > 1)) { // leading zeros
            return false;
        }
        int cLen = Math.max(b - a, c - b);
        if (c + cLen > chars.length) { // prune if there is not enough chars left
            return false;
        }

        // add the first and second numbers
        int[] temp = new int[cLen];
        int i = b - 1, j = c - 1, k = cLen - 1, carry = 0;
        while (i >= a && j >= b) {
            int sum = chars[i--] - '0' + chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (i >= a) {
            int sum = chars[i--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (j >= b) {
            int sum = chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }

        // compare sum and the third number
        k = c;
        if (carry > 0) {
            if (chars[k++] - '0' != carry) {
                return false;
            }
        }
        for (int digit : temp) {
            if (chars[k++] - '0' != digit) {
                return false;
            }
        }
        if (k == chars.length) {
            return true;
        }
        return isAdditiveNumber(chars, b, c, k);
    }
}