package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/non-decreasing-subsequences/">491. Non-decreasing Subsequences</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution646
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Solution491 {

    @Complexity(time = "O((2^n)*n)", space = "O(n)")
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), 0, Integer.MAX_VALUE);
        return res;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> tmp, int i, int prev) {
        if (i == nums.length) {
            if (tmp.size() > 1) {
                ans.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (nums[i] != prev) {
            dfs(ans, nums, tmp, i + 1, prev);
        }
        if (tmp.isEmpty() || nums[i] >= tmp.getLast()) {
            tmp.add(nums[i]);
            dfs(ans, nums, tmp, i + 1, nums[i]);
            tmp.removeLast();
        }
    }
}