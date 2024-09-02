package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/select-cells-in-grid-with-maximum-score/">3276. Select Cells in Grid With Maximum Score</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.HARD
)
public class Solution3276 {

    @Complexity(time = "O(mn*log(mn)+mn*2^m)", space = "O(mn*2^m)")
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.getFirst().size();
        int[][] nums = new int[m * n][2];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[k++] = new int[]{grid.get(i).get(j), i};
            }
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[0]));
        return dfs(new int[1 << m][nums.length], nums, (1 << m) - 1, nums.length - 1);
    }

    private int dfs(int[][] memo, int[][] nums, int mask, int i) {
        if (i < 0 || mask == 0) {
            return 0;
        }
        if (memo[mask][i] != 0) {
            return memo[mask][i];
        }

        int j = i - 1;
        while (j >= 0 && nums[j][0] == nums[i][0]) {
            j--;
        }
        int max = dfs(memo, nums, mask, j);
        for (int k = i; k > j; k--) {
            int num = nums[k][0], p = 1 << nums[k][1];
            if ((mask & p) != 0) { // unused row
                int score = dfs(memo, nums, mask ^ p, j);
                max = Math.max(max, score + num);
            }
        }
        return memo[mask][i] = max;
    }
}