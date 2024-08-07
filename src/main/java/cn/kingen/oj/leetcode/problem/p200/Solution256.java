package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/paint-house/">256. Paint House</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p200.Solution213
 * @see cn.kingen.oj.leetcode.problem.p200.Solution265
 * @see cn.kingen.oj.leetcode.problem.p200.Solution276
 */
@Question(
        paidOnly = true,
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution256 {

    @Complexity(time = "O(n)", space = "O(k)", note = "k is the number of colors")
    public int minCost(int[][] costs) {
        // cost with the last house painted red, green, blue
        int[] prev = new int[3], cur = new int[3];
        for (int[] cost : costs) {
            cur[0] = Math.min(prev[1], prev[2]) + cost[0];
            cur[1] = Math.min(prev[0], prev[2]) + cost[1];
            cur[2] = Math.min(prev[0], prev[1]) + cost[2];
            int[] tmp = prev;
            prev = cur;
            cur = tmp;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}