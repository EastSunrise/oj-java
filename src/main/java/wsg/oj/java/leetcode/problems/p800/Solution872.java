package wsg.oj.java.leetcode.problems.p800;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 872. Leaf-Similar Trees (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/leaf-similar-trees/">Leaf-Similar Trees</a>
 * @since 2021-07-27
 */
public class Solution872 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (((int) leaves1.get(i)) != leaves2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
    }
}
