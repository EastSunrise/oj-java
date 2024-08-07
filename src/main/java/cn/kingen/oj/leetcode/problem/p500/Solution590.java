package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/">590. N-ary Tree Postorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution145
 * @see cn.kingen.oj.leetcode.problem.p400.Solution429
 * @see cn.kingen.oj.leetcode.problem.p500.Solution589
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DEPTH_FIRST_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution590 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node != null) {
            for (Node child : node.children) {
                dfs(child, res);
            }
            res.add(node.val);
        }
    }
}