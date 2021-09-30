package wsg.oj.java.leetcode.problems.p900;

import java.util.LinkedList;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 919. Complete Binary Tree Inserter (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/complete-binary-tree-inserter/">Complete Binary
 * Tree Inserter</a>
 * @since 2021-07-27
 */
public class Solution919 implements Solution {

    static class CBTInserter {

        private final TreeNode root;
        private final Queue<TreeNode> parents;
        private boolean left;

        public CBTInserter(TreeNode root) {
            this.root = root;
            parents = new LinkedList<>();
            parents.offer(root);
            while (true) {
                TreeNode cur = parents.element();
                if (cur.left == null) {
                    left = true;
                    break;
                }
                parents.offer(cur.left);
                if (cur.right == null) {
                    left = false;
                    break;
                }
                parents.offer(cur.right);
                parents.remove();
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            TreeNode parent;
            if (left) {
                parent = parents.element();
                parent.left = node;
            } else {
                parent = parents.remove();
                parent.right = node;
            }
            parents.offer(node);
            left = !left;
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
