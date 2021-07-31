package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 806. Number of Lines To Write String (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-lines-to-write-string/">Number of Lines
 * To Write String</a>
 * @since 2021-07-27
 */
public class Solution806 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1, column = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            column += width;
            if (column > 100) {
                column = width;
                line++;
            }
        }
        return new int[]{line, column};
    }
}
