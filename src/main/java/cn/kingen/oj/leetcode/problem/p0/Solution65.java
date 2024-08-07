package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/valid-number/">65. Valid Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution8
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution65 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isNumber(String s) {
        int exp = s.indexOf('e');
        if (exp < 0) {
            exp = s.indexOf('E');
        }
        if (exp < 0) { // no exponent notation
            return isDecimal(s, s.length());
        } else if (exp == 0 || exp == s.length() - 1) { // with exponent notation at head or tail
            return false;
        } else { // with exponent notation
            return isDecimal(s, exp) && isInteger(s, exp + 1, s.length());
        }
    }

    private boolean isDecimal(String s, int end) {
        int start = 0;
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        int dot = s.indexOf('.', start, end);
        if (dot < 0) { // an integer
            return isUnsignedInteger(s, start, end);
        } else if (dot == start) { // a decimal starting with a dot
            return isUnsignedInteger(s, start + 1, end);
        } else if (dot == end - 1) { // an integer ending with a dot
            return isUnsignedInteger(s, start, end - 1);
        } else { // a decimal with a dot in the middle
            return isUnsignedInteger(s, start, dot) && isUnsignedInteger(s, dot + 1, end);
        }
    }

    private boolean isInteger(String s, int start, int end) {
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        return isUnsignedInteger(s, start, end);
    }

    private boolean isUnsignedInteger(String s, int start, int end) {
        if (start >= end) {
            return false;
        }
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}