package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 968. Binary Tree Cameras (HARD)
 *
 * @author Kingen
 * @see Solution979
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-cameras/">Binary Tree Cameras</a>
 * @since 2021-07-27
 */
public class Solution968 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int minCameraCover(TreeNode root) {
        int[] count = {0};
        int status = dfs(root, count);
        return status < 0 ? count[0] + 1 : count[0];
    }

    /**
     * @return -1 if the node is uncovered, 1 if a camera is installed on the node, 0 if no camera
     * is installed on the node but it's covered
     */
    public int dfs(TreeNode node, int[] count) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, count);
        int right = dfs(node.right, count);
        if (left == -1 || right == -1) {
            // install a camera to cover its uncovered children
            count[0]++;
            return 1;
        }
        if (left == 1 || right == 1) {
            // this node is covered from its children
            return 0;
        }
        // wait to be covered from its parent
        return -1;
    }
}
