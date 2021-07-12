package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution94;

/**
 * 144. Binary Tree Preorder Traversal (Easy)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution255
 * @see Solution589
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal/">Binary Tree
 * Preorder Traversal</a>
 * @since 2021-07-08
 */
public class Solution144 extends BinaryTree implements Solution {

    /**
     * @see #preorderTraversal(TreeNode, Consumer)
     * @see #preorderTraversalWithStack(TreeNode, Consumer)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res::add);
        return res;
    }
}
