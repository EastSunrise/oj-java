package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/">40. Combination Sum II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution39
 */
@Question(
    tags = {Tag.ARRAY, Tag.BACKTRACKING},
    difficulty = Difficulty.MEDIUM,
        date = "2025-01-26"
)
public class Solution40 {

    @Complexity(time = "O(2^n*n)", space = "O(n)")
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] candidates, int target, int i, List<Integer> tmp) {
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (i == candidates.length || target < candidates[i]) {
            return;
        }

        tmp.add(candidates[i]);
        dfs(ans, candidates, target - candidates[i], i + 1, tmp);
        tmp.removeLast();

        i++;
        while (i < candidates.length && candidates[i] == candidates[i - 1]) { // skip duplicates
            i++;
        }
        dfs(ans, candidates, target, i, tmp);
    }
}