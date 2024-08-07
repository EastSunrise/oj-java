package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/">39. Combination Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution17
 * @see cn.kingen.oj.leetcode.problem.p0.Solution40
 * @see cn.kingen.oj.leetcode.problem.p0.Solution77
 * @see cn.kingen.oj.leetcode.problem.p200.Solution216
 * @see cn.kingen.oj.leetcode.problem.p200.Solution254
 * @see cn.kingen.oj.leetcode.problem.p300.Solution377
 */
@Question(
        tags = {Tag.ARRAY, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution39 {

    /**
     * Sorts the array before backtracking to avoid duplicate results and invalid branches.
     */
    @Complexity(time = "O(#)", space = "O(target)")
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, target, candidates, new ArrayList<>(), 0);
        return ans;
    }

    /**
     * @param target the left target after subtracting the elements chosen in {@code chosen}
     * @param chosen list of all chosen elements
     * @param i      the start index of left elements to be chosen
     */
    private void dfs(List<List<Integer>> ans, int target, int[] candidates, List<Integer> chosen, int i) {
        if (target == 0) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        if (i >= candidates.length || candidates[i] > target) {
            return;
        }
        // choose this one
        chosen.add(candidates[i]);
        dfs(ans, target - candidates[i], candidates, chosen, i);
        chosen.removeLast();
        // don't choose this one
        dfs(ans, target, candidates, chosen, i + 1);
    }
}