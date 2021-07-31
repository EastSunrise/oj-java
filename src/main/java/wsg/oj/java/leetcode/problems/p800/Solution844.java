package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 844. Backspace String Compare (EASY)
 *
 * @author Kingen
 * @see Solution1598
 * @see <a href="https://leetcode-cn.com/problems/backspace-string-compare/">Backspace String
 * Compare</a>
 * @since 2021-07-27
 */
public class Solution844 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int hs = 0, ht = 0;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == '#') {
                hs++;
                i--;
            } else if (hs > 0) {
                hs--;
                i--;
            } else if (t.charAt(j) == '#') {
                ht++;
                j--;
            } else if (ht > 0) {
                ht--;
                j--;
            } else if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }
        if (i < 0) {
            i = j;
            s = t;
            hs = ht;
        }
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                hs++;
            } else if (hs > 0) {
                hs--;
            } else {
                return false;
            }
            i--;
        }
        return true;
    }
}
