package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 859. Buddy Strings (EASY)
 *
 * @author Kingen
 * @see Solution1657
 * @see Solution1790
 * @see <a href="https://leetcode-cn.com/problems/buddy-strings/">Buddy Strings</a>
 * @since 2021-07-27
 */
public class Solution859 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) {
            return false;
        }
        int difCount = 0;
        int[] difIndices = new int[2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (difCount == 2) {
                    return false;
                }
                difIndices[difCount++] = i;
            }
        }
        if (difCount == 2) {
            int i = difIndices[0], j = difIndices[1];
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }
        if (difCount == 1) {
            return false;
        }
        if (n > 26) {
            return true;
        }
        boolean[] letters = new boolean[26];
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (letters[idx]) {
                return true;
            }
            letters[idx] = true;
        }
        return false;
    }
}
