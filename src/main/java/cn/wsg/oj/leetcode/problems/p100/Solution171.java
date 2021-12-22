package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 171. Excel Sheet Column Number (Easy)
 *
 * @author Kingen
 * @see Solution168
 * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-number/">Excel Sheet Column
 * Number</a>
 */
public class Solution171 implements Solution {

    /**
     * 26-ary.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (char c : columnTitle.toCharArray()) {
            sum = (c - 'A') + sum * 26;
        }
        return sum;
    }
}
