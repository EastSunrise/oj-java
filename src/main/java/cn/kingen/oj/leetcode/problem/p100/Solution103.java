package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

import static cn.kingen.oj.leetcode.util.TreeUtils.traverseTreeByLevel;


/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">103. Binary Tree Zigzag Level Order Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution102
 */
@Question(
        tags = {Tag.TREE, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution103 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverseTreeByLevel(root, (i, vs) -> ans.add(i % 2 == 0 ? vs : vs.reversed()));
        return ans;
    }
}