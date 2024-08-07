package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/">2673. Make Costs of Paths Equal in a Binary Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.TREE, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2673 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 1; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i - 1]);
            cost[i / 2 - 1] += Math.max(cost[i], cost[i - 1]);
        }
        return ans;
    }
}