package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/restore-the-array-from-adjacent-pairs/">1743. Restore the Array From Adjacent Pairs</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1743 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] edge : adjacentPairs) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, key -> new ArrayList<>(2)).add(v);
            graph.computeIfAbsent(v, key -> new ArrayList<>(2)).add(u);
        }

        int[] ans = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) { // find the first one
                ans[0] = entry.getKey();
                ans[1] = entry.getValue().getFirst();
                break;
            }
        }

        for (int i = 2; i < n; i++) {
            int u = ans[i - 1], p = ans[i - 2];
            List<Integer> vs = graph.get(u);
            for (int v : vs) {
                if (v != p) {
                    ans[i] = v;
                    break;
                }
            }
        }
        return ans;
    }
}