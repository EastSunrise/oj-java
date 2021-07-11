package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 116. Populating Next Right Pointers in Each Node (Medium)
 *
 * @author Kingen
 * @see Solution117
 * @see Solution199
 * @see <a href="https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/">Populating
 * Next Right Pointers in Each Node</a>
 * @since 2021-07-11
 */
class Solution116 implements Solution {

    /**
     * @see #PREORDER
     */
    public Node connect(Node root) {
        if (root == null || root.right == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    /**
     * Definition for a Node.
     */
    static class Node {

        int val;
        Node left;
        Node right;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
