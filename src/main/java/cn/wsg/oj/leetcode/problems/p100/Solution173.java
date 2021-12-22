package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p0.Solution94;
import cn.wsg.oj.leetcode.problems.p200.Solution284;
import java.util.Deque;
import java.util.LinkedList;

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
 */
public class Solution173 implements Solution {

    /**
     * @see #PREORDER
     */
    static class BSTIterator {

        private final Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            int val = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
