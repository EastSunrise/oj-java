package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/">90. Subsets II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution78
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1982
 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.BACKTRACKING},
    difficulty = Difficulty.MEDIUM,
    daily = "2025-02-05"
)
public class Solution90 {

    @Complexity(time = "O(n*2^n)", space = "O(2^n)")
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, m = 0;
        int[][] freq = new int[n][];
        for (int i = 0, j; i < n; ) {
            j = i + 1;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            freq[m++] = new int[]{nums[i], j - i};
            i = j;
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, freq, m, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[][] freq, int m, int i, List<Integer> path) {
        if (i == m) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int num = freq[i][0], cnt = freq[i][1];
        dfs(ans, freq, m, i + 1, path);
        for (int j = 0; j < cnt; j++) {
            path.add(num);
            dfs(ans, freq, m, i + 1, path);
        }
        for (int j = 0; j < cnt; j++) {
            path.removeLast();
        }
    }
}