package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 429. N-ary Tree Level Order Traversal (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution589
 * @see Solution590
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree
 * Level Order Traversal</a>
 * @since 2021-07-07
 */
class Solution429 implements Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node head = queue.remove();
                level.add(head.val);
                queue.addAll(head.children);
            }
            res.add(level);
        }
        return res;
    }

    /**
     * Definition for a Node.
     */
    private static class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
