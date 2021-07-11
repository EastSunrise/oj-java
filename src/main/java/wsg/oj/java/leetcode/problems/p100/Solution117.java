package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 117. Populating Next Right Pointers in Each Node II (Medium)
 *
 * @author Kingen
 * @see Solution116
 * @see <a href="https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/">Populating
 * Next Right Pointers in Each Node II</a>
 * @since 2021-07-11
 */
class Solution117 extends Solution116 implements Solution {

    /**
     * @see #PREORDER
     */
    @Override
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            // get the next node
            Node next = null;
            Node cursor = root.next;
            while (cursor != null) {
                if (cursor.left != null) {
                    next = cursor.left;
                    break;
                }
                if (cursor.right != null) {
                    next = cursor.right;
                    break;
                }
                cursor = cursor.next;
            }
            if (root.right != null) {
                root.right.next = next;
                next = root.right;
            }
            if (root.left != null) {
                root.left.next = next;
            }
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}
