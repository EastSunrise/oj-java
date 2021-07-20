package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
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
public class Solution501 extends BinaryTree implements Solution {

    /**
     * @see #INORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int[] findMode(TreeNode root) {
        // temp: current number, count of current number, count of each mode
        int[] temp = new int[3];
        List<Integer> modes = new ArrayList<>();
        inorderTraversal(root, val -> {
            if (val == temp[0]) {
                temp[1]++;
            } else {
                temp[0] = val;
                temp[1] = 1;
            }
            if (temp[1] > temp[2]) {
                modes.clear();
                modes.add(temp[0]);
                temp[2] = temp[1];
            } else if (temp[1] == temp[2]) {
                modes.add(temp[0]);
            }
        });
        int[] res = new int[modes.size()];
        int i = 0;
        for (int mode : modes) {
            res[i++] = mode;
        }
        return res;
    }
}
