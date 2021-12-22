package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p0.Solution94;
import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/balance-a-binary-search-tree/">Balance a Binary
 * Search Tree</a>
 */
public class Solution1382 extends Solution94 {

    /**
     * @see #INORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return build(values, 0, values.size());
    }

    private void inorder(TreeNode p, List<Integer> values) {
        if (p != null) {
            inorder(p.left, values);
            values.add(p.val);
            inorder(p.right, values);
        }
    }

    private TreeNode build(List<Integer> values, int fromIn, int toEx) {
        if (fromIn == toEx) {
            return null;
        }
        if (toEx - fromIn == 1) {
            return new TreeNode(values.get(fromIn));
        }
        int mid = fromIn + (toEx - fromIn) / 2;
        return new TreeNode(values.get(mid), build(values, fromIn, mid),
            build(values, mid + 1, toEx));
    }
}
