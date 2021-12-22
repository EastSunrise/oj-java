package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表  LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/">二叉搜索树与双向链表
 * LCOF</a>
 */
public class Offer36 implements Solution {

    /**
     * @see #INORDER
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node[] tmp = new Node[2];
        inorder(root, tmp);
        tmp[0].left = tmp[1];
        tmp[1].right = tmp[0];
        return tmp[0];
    }

    private void inorder(Node node, Node[] tmp) {
        if (node == null) {
            return;
        }
        inorder(node.left, tmp);
        if (tmp[0] == null) {
            // the head node
            tmp[0] = node;
        }
        if (tmp[1] != null) {
            tmp[1].right = node;
            node.left = tmp[1];
        }
        tmp[1] = node;
        inorder(node.right, tmp);
    }

    /**
     * Definition for a Node.
     */
    static class Node {

        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
