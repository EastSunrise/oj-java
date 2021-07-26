package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 6. ZigZag Conversion (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/">ZigZag Conversion</a>
 * @since 2021-07-10
 */
public class Solution6 implements Solution {

    /**
     * Finds the regular pattern of indices of each row.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        // Each 2*numRows-2 as a group
        int step = 2 * numRows - 2;
        // the 1st row, one element each group
        for (int i = 0; i < len; i += step) {
            builder.append(s.charAt(i));
        }
        // the jth row, 0 < j < numRows-1, two elements each group
        for (int j = 1, end = numRows - 1; j < end; j++) {
            // the difference between the two elements
            int dif = 2 * (numRows - 1 - j);
            for (int i = j; i < len; i += step) {
                builder.append(s.charAt(i));
                int second = i + dif;
                if (second < len) {
                    builder.append(s.charAt(second));
                }
            }
        }
        // the last row
        for (int i = numRows - 1; i < len; i += step) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
