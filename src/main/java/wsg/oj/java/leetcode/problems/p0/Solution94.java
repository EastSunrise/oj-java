package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution144;
import wsg.oj.java.leetcode.problems.p100.Solution145;
import wsg.oj.java.leetcode.problems.p100.Solution173;
import wsg.oj.java.leetcode.problems.p200.Solution230;
import wsg.oj.java.leetcode.problems.p700.Solution783;

/**
 * 94. Binary Tree Inorder Traversal (Easy)
 *
 * @author Kingen
 * @see Solution98
 * @see Solution144
 * @see Solution145
 * @see Solution173
 * @see Solution230
 * @see Solution272
 * @see Solution285
 * @see Solution426
 * @see Solution783
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">Binary Tree
 * Inorder Traversal</a>
 * @since 2021-07-08
 */
public class Solution94 extends BinaryTree implements Solution {

    /**
     * @see #inorderTraversal(TreeNode, Consumer)
     * @see #inorderTraversalWithStack(TreeNode, Consumer)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res::add);
        return res;
    }
}
