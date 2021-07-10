package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 22. Generate Parentheses (Medium)
 *
 * @author Kingen
 * @see Solution17
 * @see Solution20
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">Generate Parentheses</a>
 * @since 2021-07-10
 */
class Solution22 implements Solution {

    /**
     * @see #BACKTRACKING
     * @see wsg.oj.java.Complexity#TIME_2_N
     * @see wsg.oj.java.Complexity#SPACE_2_N
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, new StringBuilder(2 * n), n, 0, 0);
        return res;
    }

    /**
     * @param tmp   current parentheses
     * @param left  the count of '(' in p
     * @param right the count of ')' in p
     */
    private void generateParenthesis(List<String> res, StringBuilder tmp,
        int n, int left, int right) {
        if (left < right || left > n) {
            return;
        }
        if (right == n) {
            res.add(tmp.toString());
            return;
        }
        tmp.append('(');
        generateParenthesis(res, tmp, n, left + 1, right);
        tmp.setCharAt(tmp.length() - 1, ')');
        generateParenthesis(res, tmp, n, left, right + 1);
        tmp.deleteCharAt(tmp.length() - 1);
    }
}
