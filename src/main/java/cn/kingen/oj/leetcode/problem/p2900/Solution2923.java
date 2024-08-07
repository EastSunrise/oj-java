package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-champion-i/">2923. Find Champion I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.EASY
)
public class Solution2923 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (grid[ans][i] != 1) {
                ans = i;
            }
        }
        return ans;
    }
}