package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17. Letter Combinations of a Phone Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution22
 * @see cn.kingen.oj.leetcode.problem.p0.Solution39
 * @see cn.kingen.oj.leetcode.problem.p400.Solution401
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution17 {

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

    @Complexity(time = "O(3^n)", space = "O(n)")
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>((int) Math.pow(3, n));
        dfs(ans, digits, 0, new StringBuilder(n));
        return ans;
    }

    private void dfs(List<String> ans, String digits, int i, StringBuilder tmp) {
        if (i == digits.length()) {
            ans.add(tmp.toString());
            return;
        }
        for (char ch : dict[digits.charAt(i) - '2']) {
            tmp.append(ch);
            dfs(ans, digits, i + 1, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}