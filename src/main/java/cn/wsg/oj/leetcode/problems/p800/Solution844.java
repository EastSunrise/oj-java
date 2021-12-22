package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1500.Solution1598;

/**
 * 844. Backspace String Compare (EASY)
 *
 * @author Kingen
 * @see Solution1598
 * @see <a href="https://leetcode-cn.com/problems/backspace-string-compare/">Backspace String
 * Compare</a>
 */
public class Solution844 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
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
