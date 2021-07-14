package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution28;

/**
 * 459. Repeated Substring Pattern (Easy)
 *
 * @author Kingen
 * @see Solution28
 * @see Solution686
 * @see <a href="https://leetcode-cn.com/problems/repeated-substring-pattern/">Repeated Substring
 * Pattern</a>
 * @since 2021-07-14
 */
public class Solution459 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int subLen = len / 2; subLen > 0; subLen--) {
            if (len % subLen == 0 && repeatedSubstringPattern(chars, len, subLen)) {
                return true;
            }
        }
        return false;
    }

    private boolean repeatedSubstringPattern(char[] chars, int len, int subLen) {
        for (int i = subLen; i < len; i++) {
            if (chars[i] != chars[i - subLen]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Cuts the first target substring and appends it after the left substring. The result should
     * equal to s.
     */
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
