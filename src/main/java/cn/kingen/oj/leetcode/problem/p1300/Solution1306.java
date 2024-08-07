package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/jump-game-iii/">1306. Jump Game III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution45
 * @see cn.kingen.oj.leetcode.problem.p0.Solution55
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1871
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2297
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2770
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution1306 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    private boolean dfs(int[] arr, int i) {
        if (i < 0 || i >= arr.length || arr[i] < 0) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        arr[i] = -arr[i]; // visited
        return dfs(arr, i + arr[i]) || dfs(arr, i - arr[i]);
    }
}