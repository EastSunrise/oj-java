package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-paths/">257. Binary Tree Paths</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution113
 * @see cn.kingen.oj.leetcode.problem.p900.Solution988
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2096
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.STRING, Tag.BACKTRACKING, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution257 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> ans = new ArrayList<>(left.size() + right.size());
        for (String path : left) {
            ans.add(root.val + "->" + path);
        }
        for (String path : right) {
            ans.add(root.val + "->" + path);
        }
        if (ans.isEmpty()) {
            ans.add(String.valueOf(root.val));
        }
        return ans;
    }
}