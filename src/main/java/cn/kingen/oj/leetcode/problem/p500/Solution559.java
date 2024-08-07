package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/">559. Maximum Depth of N-ary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution104
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution559 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }
}