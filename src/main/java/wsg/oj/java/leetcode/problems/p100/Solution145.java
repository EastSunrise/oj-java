package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution94;

/**
 * 145. Binary Tree Postorder Traversal (Easy)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution590
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal/">Binary Tree
 * Postorder Traversal</a>
 * @since 2021-07-08
 */
public class Solution145 extends BinaryTree implements Solution {

    /**
     * @see #postorderTraversal(TreeNode, Consumer)
     * @see #postorderTraversalWithStack(TreeNode, Consumer)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res::add);
        return res;
    }
}
