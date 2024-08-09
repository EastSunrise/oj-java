package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/">3244. Shortest Distance After Road Addition Queries II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.GRAPH, Tag.ARRAY, Tag.ORDERED_SET},
        difficulty = Difficulty.HARD
)
public class Solution3244 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        TreeSet<Integer> cities = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            cities.add(i);
        }
        int[] ans = new int[m];
        for (int k = 0; k < m; k++) {
            int u = queries[k][0], v = queries[k][1];
            var iterator = cities.subSet(u, false, v, false).iterator();
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
            ans[k] = cities.size() - 1;
        }
        return ans;
    }
}