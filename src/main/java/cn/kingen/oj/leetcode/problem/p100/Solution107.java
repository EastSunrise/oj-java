package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cn.kingen.oj.leetcode.util.TreeUtils.traverseTreeByLevel;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/">107. Binary Tree Level Order Traversal II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution102
 * @see cn.kingen.oj.leetcode.problem.p600.Solution637
 */
@Question(
        tags = {Tag.TREE, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution107 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverseTreeByLevel(root, (i, vs) -> ans.add(vs));
        Collections.reverse(ans);
        return ans;
    }
}