package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/strobogrammatic-number-ii/">247. Strobogrammatic Number II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution246
 * @see cn.kingen.oj.leetcode.problem.p200.Solution248
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2081
 */
@Question(
        paidOnly = true,
        tags = {Tag.RECURSION, Tag.ARRAY, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution247 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<String> findStrobogrammatic(int n) {
        char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        char[] chars = new char[n];
        List<String> ans = new ArrayList<>();
        if (n > 1) { // no leading zeros
            for (int i = 1; i < pairs.length; i++) {
                chars[0] = pairs[i][0];
                chars[n - 1] = pairs[i][1];
                dfs(ans, pairs, chars, 1, n - 2);
            }
        } else {
            dfs(ans, pairs, chars, 0, n - 1);
        }
        return ans;
    }

    private void dfs(List<String> ans, char[][] pairs, char[] chars, int i, int j) {
        if (i > j) {
            ans.add(new String(chars));
            return;
        }
        if (i == j) {
            chars[i] = '0';
            ans.add(new String(chars));
            chars[i] = '1';
            ans.add(new String(chars));
            chars[i] = '8';
            ans.add(new String(chars));
            return;
        }
        for (char[] pair : pairs) {
            chars[i] = pair[0];
            chars[j] = pair[1];
            dfs(ans, pairs, chars, i + 1, j - 1);
        }
    }
}