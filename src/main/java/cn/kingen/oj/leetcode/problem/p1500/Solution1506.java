package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.*;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-root-of-n-ary-tree/">1506. Find Root of N-Ary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1516
 */
@Question(
        paidOnly = true,
        tags = {Tag.BIT_MANIPULATION, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1506 {

    /**
     * Each node except the root one will be accessed twice, one as parent and another as child.
     */
    @Complexity(time = "O(n)", space = "O(1)", note = "n is the number of nodes")
    public Node findRoot(List<Node> tree) {
        int xor = 0;
        for (Node p : tree) {
            xor ^= p.val;
            for (Node child : p.children) {
                xor ^= child.val;
            }
        }
        for (Node p : tree) {
            if (xor == p.val) {
                return p;
            }
        }
        return null;
    }
}