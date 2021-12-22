package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/brick-wall/">Brick Wall</a>
 */
public class Solution554 implements Solution {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0, size = row.size() - 1;
            for (int i = 0; i < size; i++) {
                sum += row.get(i);
                prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (int count : prefixSums.values()) {
            max = Math.max(max, count);
        }
        return wall.size() - max;
    }
}
