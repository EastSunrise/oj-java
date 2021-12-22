package cn.wsg.oj.leetcode.problems.p1100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.List;

/**
 * 1104. Path In Zigzag Labelled Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/">Path In
 * Zigzag Labelled Binary Tree</a>
 */
public class Solution1104 implements Solution {

    /**
     * @complexity T=O(log{label})
     * @complexity S=O(1)
     */
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int left = 1;
        while (left <= label) {
            left = 2 * left;
        }
        while (left > 1) {
            res.addFirst(label);
            label = (left / 2 + left - 1 - label) / 2;
            left /= 2;
        }
        return res;
    }
}
