package wsg.oj.java.leetcode.problems.p100;

import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution94;

/**
 * 173. Binary Search Tree Iterator (Medium)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution251
 * @see Solution281
 * @see Solution284
 * @see Solution285
 * @see Solution1586
 * @see <a href="https://leetcode-cn.com/problems/binary-search-tree-iterator/">Binary Search Tree
 * Iterator</a>
 * @since 2021-06-25
 */
public class Solution173 implements Solution {

    static class BSTIterator {

        private final Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            do {
                stack.push(root);
                root = root.left;
            } while (root != null);
        }

        public int next() {
            TreeNode node = stack.pop();
            int res = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return res;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
