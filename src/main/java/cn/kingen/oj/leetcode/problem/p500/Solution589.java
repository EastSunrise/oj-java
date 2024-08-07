package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/">589. N-ary Tree Preorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution144
 * @see cn.kingen.oj.leetcode.problem.p400.Solution429
 * @see cn.kingen.oj.leetcode.problem.p500.Solution590
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DEPTH_FIRST_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution589 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node t = stack.pop();
            ans.add(t.val);
            for (int i = t.children.size() - 1; i >= 0; i--) {
                Node child = t.children.get(i);
                stack.push(child);
            }
        }
        return ans;
    }
}