package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution102;
import cn.wsg.oj.leetcode.problems.p500.Solution589;
import cn.wsg.oj.leetcode.problems.p500.Solution590;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution589
 * @see Solution590
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree
 * Level Order Traversal</a>
 */
public class Solution429 implements Solution {

    /**
     * @complexity T=O(N), N=the number of nodes
     * @complexity S=O(L), L=the number of nodes in a level
     */
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
