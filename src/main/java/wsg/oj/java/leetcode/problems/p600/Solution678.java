package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 678. Valid Parenthesis String (MEDIUM)
 *
 * @author Kingen
 * @see Solution761
 * @see <a href="https://leetcode-cn.com/problems/valid-parenthesis-string/">Valid Parenthesis
 * String</a>
 * @since 2021-07-23
 */
class Solution678 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean checkValidString(String s) {
        int n = s.length();
        int lefts = 0, stars = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                lefts++;
            } else if (ch == '*') {
                stars++;
            } else {
                if (lefts > 0) {
                    lefts--;
                } else if (stars > 0) {
                    stars--;
                } else {
                    return false;
                }
            }
        }
        int rights = stars = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                rights++;
            } else if (s.charAt(i) == '*') {
                stars++;
            } else {
                if (rights > 0) {
                    rights--;
                } else if (stars > 0) {
                    stars--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
