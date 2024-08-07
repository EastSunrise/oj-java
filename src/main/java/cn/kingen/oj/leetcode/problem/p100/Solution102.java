package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

import static cn.kingen.oj.leetcode.util.TreeUtils.traverseTreeByLevel;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">102. Binary Tree Level Order Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution103
 * @see cn.kingen.oj.leetcode.problem.p100.Solution107
 * @see cn.kingen.oj.leetcode.problem.p100.Solution111
 * @see cn.kingen.oj.leetcode.problem.p300.Solution314
 * @see cn.kingen.oj.leetcode.problem.p600.Solution637
 * @see cn.kingen.oj.leetcode.problem.p400.Solution429
 * @see cn.kingen.oj.leetcode.problem.p900.Solution993
 */
@Question(
        tags = {Tag.TREE, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution102 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverseTreeByLevel(root, (i, vs) -> ans.add(vs));
        return ans;
    }
}