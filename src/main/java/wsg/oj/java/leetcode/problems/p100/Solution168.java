package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 168. Excel Sheet Column Title (Easy)
 *
 * @author Kingen
 * @see Solution171
 * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-title/">Excel Sheet Column
 * Title</a>
 * @since 2021-07-12
 */
public class Solution168 implements Solution {

    /**
     * 26-ary.
     *
     * @complexity T=O(k), k=log_{26}{n}
     * @complexity S=O(k)
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0) {
                mod = 26;
            }
            str.insert(0, (char) (64 + mod));
            columnNumber = (columnNumber - mod) / 26;
        }
        return str.toString();
    }
}
