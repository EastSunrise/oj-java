package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Node;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution104;

/**
 * 559. Maximum Depth of N-ary Tree (EASY)
 *
 * @author Kingen
 * @see Solution104
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of
 * N-ary Tree</a>
 * @since 2021-07-20
 */
public class Solution559 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }

}
