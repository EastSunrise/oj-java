package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/">216. Combination Sum III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution39
 */
@Question(
        tags = {Tag.ARRAY, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution216 {

    @Complexity(time = "O(C(k,M)*k)", space = "O(M)", note = "C(k,M) is the combination and M is the count of distinct numbers")
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < k * (k + 1) / 2 || n > (19 - k) * k / 2) {
            return ans;
        }
        dfs(ans, new ArrayList<>(k), k, n, 1);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer> path, int k, int n, int i) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (i > n || i > 9) {
            return;
        }
        // choose i
        path.add(i);
        dfs(ans, path, k - 1, n - i, i + 1);
        path.removeLast();
        // don't choose i
        dfs(ans, path, k, n, i + 1);
    }
}