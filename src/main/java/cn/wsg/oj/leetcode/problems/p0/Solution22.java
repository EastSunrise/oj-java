package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses (Medium)
 *
 * @author Kingen
 * @see Solution17
 * @see Solution20
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">Generate Parentheses</a>
 */
class Solution22 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_2_N
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder(" ".repeat(2 * n));
        dfs(res, tmp, n, 0, 0);
        return res;
    }

    /**
     * @param tmp   current parentheses
     * @param left  the count of '(' in tmp
     * @param right the count of ')' in tmp
     */
    private void dfs(List<String> res, StringBuilder tmp, int n, int left, int right) {
        if (left < right || left > n) {
            return;
        }
        if (right == n) {
            res.add(tmp.toString());
            return;
        }
        int i = left + right;
        tmp.setCharAt(i, '(');
        dfs(res, tmp, n, left + 1, right);
        tmp.setCharAt(i, ')');
        dfs(res, tmp, n, left, right + 1);
    }
}
