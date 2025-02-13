package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/">47. Permutations II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution31
 * @see cn.kingen.oj.leetcode.problem.p0.Solution46
 * @see cn.kingen.oj.leetcode.problem.p200.Solution267
 * @see cn.kingen.oj.leetcode.problem.p900.Solution996
 */
@Question(tags =
    {Tag.ARRAY, Tag.BACKTRACKING, Tag.SORTING},
    difficulty = Difficulty.MEDIUM,
        date = "2025-02-06"
)
public class Solution47 {

    @Complexity(time = "O(n*n!)", space = "O(n)")
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, new boolean[n], new ArrayList<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (visited[j] || (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1])) {
                continue;
            }
            path.add(nums[j]);
            visited[j] = true;
            backtrack(ans, nums, visited, path);
            visited[j] = false;
            path.removeLast();
        }
    }
}