package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution401;
import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number (Medium)
 *
 * @author Kingen
 * @see Solution22
 * @see Solution39
 * @see Solution401
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">Letter
 * Combinations of a Phone Number</a>
 */
public class Solution17 implements Solution {

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
     * @see #DFS
     */
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>((int) Math.pow(3, n));
        dfs(res, digits, new StringBuilder(n), 0);
        return res;
    }

    private void dfs(List<String> res, String digits, StringBuilder tmp, int i) {
        if (i == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        for (char ch : dict[digits.charAt(i) - '2']) {
            tmp.append(ch);
            dfs(res, digits, tmp, i + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
