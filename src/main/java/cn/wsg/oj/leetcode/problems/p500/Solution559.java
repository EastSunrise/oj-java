package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Node;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution104;

/**
 * 559. Maximum Depth of N-ary Tree (EASY)
 *
 * @author Kingen
 * @see Solution104
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of
 * N-ary Tree</a>
 */
public class Solution559 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
