package wsg.oj.java.leetcode.problems.p900;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 987. Vertical Order Traversal of a Binary Tree (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/">Vertical
 * Order Traversal of a Binary Tree</a>
 * @since 2021-07-27
 */
public class Solution987 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        traverse(nodes, root, 0, 0);
        nodes.sort(Comparator.<int[], Integer>comparing(arr -> arr[0])
            .thenComparing(arr -> arr[1])
            .thenComparing(arr -> arr[2]));
        LinkedList<List<Integer>> res = new LinkedList<>();
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            if (node[0] != prevCol) {
                // a new column
                res.add(new ArrayList<>());
                prevCol = node[0];
            }
            res.getLast().add(node[2]);
        }
        return res;
    }

    private void traverse(List<int[]> nodes, TreeNode node, int r, int c) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{c, r, node.val});
        traverse(nodes, node.left, r + 1, c - 1);
        traverse(nodes, node.right, r + 1, c + 1);
    }
}
