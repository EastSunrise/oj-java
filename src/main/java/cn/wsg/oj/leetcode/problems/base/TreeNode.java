package cn.wsg.oj.leetcode.problems.base;

/**
 * Definition for a binary tree node.
 * <p>
 * Use {@link cn.kingen.oj.leetcode.support.TreeNode} instead.
 */
@Deprecated(forRemoval = true)
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
