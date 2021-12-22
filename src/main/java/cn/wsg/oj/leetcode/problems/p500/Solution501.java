package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p0.Solution98;
import java.util.ArrayList;
import java.util.List;

/**
 * 501. Find Mode in Binary Search Tree (EASY)
 *
 * @author Kingen
 * @see Solution98
 * @see <a href="https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/">Find Mode in
 * Binary Search Tree</a>
 */
public class Solution501 implements Solution {

    /**
     * @see #INORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
