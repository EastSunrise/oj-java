package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/the-number-of-beautiful-subsets/">2597. The Number of Beautiful Subsets</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1718

 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING, Tag.COMBINATORICS, Tag.SORTING},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-07"
)
public class Solution2597 {

    @Complexity(time = "O(2^n)", space = "O(n)")
    public int beautifulSubsets(int[] nums, int k) {
        return dfs(nums, k, 0, new HashMap<>(nums.length)) - 1;
    }

    private int dfs(int[] nums, int k, int i, Map<Integer, Integer> visited) {
        if (i == nums.length) {
            return 1;
        }
        int ans = dfs(nums, k, i + 1, visited);
        if (!visited.containsKey(nums[i] - k) && !visited.containsKey(nums[i] + k)) {
            visited.merge(nums[i], 1, Integer::sum);
            ans += dfs(nums, k, i + 1, visited);
            visited.computeIfPresent(nums[i], (key, value) -> value == 1 ? null : value - 1);
        }
        return ans;
    }
}