package wsg.oj.java.leetcode.problems;

/**
 * Solutions to problems No.116, No.117.
 *
 * @author Kingen
 * @since 2021/6/29
 */
public class Solution116 extends Solution {

    /**
     * 116. Populating Next Right Pointers in Each Node (Medium)
     *
     * @see Solution116#connectII(Node)
     * @see Solution101#rightSideView(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/">Populating
     * Next Right Pointers in Each Node</a>
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
     * 117. Populating Next Right Pointers in Each Node II (Medium)
     *
     * @see Solution116#connect(Node)
     * @see <a href="https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/">Populating
     * Next Right Pointers in Each Node II</a>
     */
    public Node connectII(Node root) {
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
