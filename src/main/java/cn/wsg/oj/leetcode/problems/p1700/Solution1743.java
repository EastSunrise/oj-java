package cn.wsg.oj.leetcode.problems.p1700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.GraphSolution;
import java.util.List;
import java.util.Map;

/**
 * 1743. Restore the Array From Adjacent Pairs (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/">Restore
 * the Array From Adjacent Pairs</a>
 */
public class Solution1743 implements GraphSolution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> edges = mapToUndirectedEdges(adjacentPairs);
        int value = 0;
        for (Map.Entry<Integer, List<Integer>> entry : edges.entrySet()) {
            if (entry.getValue().size() == 1) {
                value = entry.getKey();
                break;
            }
        }

        int[] nums = new int[n];
        nums[0] = value;
        nums[1] = edges.get(value).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> neighbours = edges.get(nums[i - 1]);
            nums[i] = neighbours.get(0) == nums[i - 2] ? neighbours.get(1) : neighbours.get(0);
        }
        return nums;
    }
}
