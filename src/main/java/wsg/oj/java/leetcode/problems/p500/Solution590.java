package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Node;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution145;
import wsg.oj.java.leetcode.problems.p400.Solution429;

/**
 * 590. N-ary Tree Postorder Traversal (EASY)
 * <p>
 * todo traverse iteratively
 *
 * @author Kingen
 * @see Solution145
 * @see Solution429
 * @see Solution589
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree
 * Postorder Traversal</a>
 * @since 2021-07-20
 */
public class Solution590 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node node, List<Integer> res) {
        if (node != null) {
            for (Node child : node.children) {
                postorder(child, res);
            }
            res.add(node.val);
        }
    }
}
