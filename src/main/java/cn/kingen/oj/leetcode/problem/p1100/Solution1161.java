package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.*;

import static cn.kingen.oj.leetcode.util.TreeUtils.traverseTreeByLevel;

/**
 * <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/">1161. Maximum Level Sum of a Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2583
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2641
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1161 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int maxLevelSum(TreeNode root) {
        int[] tmp = {Integer.MIN_VALUE, 0};
        traverseTreeByLevel(root, (i, vs) -> {
            int sum = 0;
            for (int v : vs) {
                sum += v;
            }
            if (sum > tmp[0]) {
                tmp[0] = sum;
                tmp[1] = i;
            }
        });
        return tmp[1] + 1;
    }
}