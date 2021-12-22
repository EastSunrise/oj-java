package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">Minimum
 * Number of Vertices to Reach All Nodes</a>
 */
public class Solution1557 implements Solution {

    /**
     * @complexity T=O(|E|+n)
     * @complexity S=O(n)
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegrees = new int[n];
        for (List<Integer> edge : edges) {
            inDegrees[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
