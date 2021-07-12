package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 171. Excel Sheet Column Number (Easy)
 *
 * @author Kingen
 * @see Solution168
 * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-number/">Excel Sheet Column
 * Number</a>
 * @since 2021-07-12
 */
class Solution171 implements Solution {

    /**
     * 26-ary.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (char c : columnTitle.toCharArray()) {
            sum = (c - 'A') + sum * 26;
        }
        return sum;
    }
}
