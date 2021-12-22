package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Node;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution144;
import cn.wsg.oj.leetcode.problems.p400.Solution429;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N-ary Tree Preorder Traversal (EASY)
 *
 * @author Kingen
 * @see Solution144
 * @see Solution429
 * @see Solution590
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/">N-ary Tree
 * Preorder Traversal</a>
 */
public class Solution589 implements Solution {

    /**
     * @see #PREORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            for (Node child : node.children) {
                preorder(child, res);
            }
        }
    }

    /**
     * @see #PREORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public List<Integer> preorderWithStack(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            res.add(current.val);
            for (Node child : current.children) {
                stack.push(child);
            }
        }
        return res;
    }
}
