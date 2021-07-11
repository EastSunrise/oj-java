package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 17. Letter Combinations of a Phone Number (Medium)
 *
 * @author Kingen
 * @see Solution22
 * @see Solution39
 * @see Solution401
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">Letter
 * Combinations of a Phone Number</a>
 * @since 2021-07-10
 */
class Solution17 implements Solution {

    char[][] dict = new char[][]{
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    /**
     * @complexity T=O(n^k), k=the average numbers of characters each digit represents.
     * @complexity S=O(n^k)
     * @see #BACKTRACKING
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>((int) Math.pow(3, digits.length()));
        if (digits.length() == 0) {
            return res;
        }
        letterCombinations(res, digits, new StringBuilder(digits.length()), 0);
        return res;
    }

    private void letterCombinations(List<String> res, String digits, StringBuilder tmp, int idx) {
        if (idx == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        char[] chars = dict[digits.charAt(idx) - '2'];
        for (char ch : chars) {
            tmp.append(ch);
            letterCombinations(res, digits, tmp, idx + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

}
