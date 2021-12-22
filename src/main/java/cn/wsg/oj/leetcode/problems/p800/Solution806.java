package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 806. Number of Lines To Write String (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-lines-to-write-string/">Number of Lines
 * To Write String</a>
 */
public class Solution806 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
