package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p0.Solution98;

/**
 * 501. Find Mode in Binary Search Tree (EASY)
 *
 * @author Kingen
 * @see Solution98
 * @see <a href="https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/">Find Mode in
 * Binary Search Tree</a>
 * @since 2021-07-20
 */
public class Solution501 implements Solution {

    /**
     * @see #INORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int[] findMode(TreeNode root) {
        // tmp: current number, count of current number, count of each mode
        int[] tmp = new int[3];
        List<Integer> modes = new ArrayList<>();
        inorderTraversal(modes, root, tmp);
        return toArray(modes);
    }

    private void inorderTraversal(List<Integer> modes, TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }
        inorderTraversal(modes, node, tmp);
        if (node.val == tmp[0]) {
            tmp[1]++;
        } else {
            tmp[0] = node.val;
            tmp[1] = 1;
        }
        if (tmp[1] > tmp[2]) {
            modes.clear();
            modes.add(tmp[0]);
            tmp[2] = tmp[1];
        } else if (tmp[1] == tmp[2]) {
            modes.add(tmp[0]);
        }
        inorderTraversal(modes, node, tmp);
    }
}
