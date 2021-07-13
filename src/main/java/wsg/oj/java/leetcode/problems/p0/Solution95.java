package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution241;

/**
 * 95. Unique Binary Search Trees II (Medium)
 *
 * @author Kingen
 * @see Solution96
 * @see Solution241
 * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees-ii/">Unique Binary
 * Search Trees II</a>
 * @since 2021-07-11
 */
public class Solution95 implements Solution {

    /**
     * Catalan number G(n).
     *
     * @complexity T=O(nG(n))
     * @complexity S=O(nG(n))
     * @see #POSTORDER
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = generateTrees(min, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, max);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        return res;
    }

}
