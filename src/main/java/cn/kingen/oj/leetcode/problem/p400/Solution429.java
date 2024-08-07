package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">429. N-ary Tree Level Order Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution102
 * @see cn.kingen.oj.leetcode.problem.p500.Solution589
 * @see cn.kingen.oj.leetcode.problem.p500.Solution590
 */
@Question(
        tags = {Tag.TREE, Tag.BREADTH_FIRST_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution429 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            while (size-- > 0) {
                Node t = queue.remove();
                level.add(t.val);
                queue.addAll(t.children);
            }
            ans.add(level);
        }
        return ans;
    }
}