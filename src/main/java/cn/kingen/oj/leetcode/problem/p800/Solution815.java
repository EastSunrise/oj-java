package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/bus-routes/">815. Bus Routes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2361

 */
@Question(
    tags = {Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.HASH_TABLE},
    difficulty = Difficulty.HARD
)
public class Solution815 {

    @Complexity(time = "O(S)", space = "O(S)", note = "S = |routes|")
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        Map<Integer, List<Integer>> site2Routes = new HashMap<>();
        for (int r = 0; r < n; r++) {
            for (int s : routes[r]) {
                site2Routes.computeIfAbsent(s, k -> new ArrayList<>()).add(r);
            }
        }
        if (!site2Routes.containsKey(source) || !site2Routes.containsKey(target)) {
            return -1;
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        for (int dist = 0; !queue.isEmpty(); dist++) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                int s = queue.remove();
                if (s == target) {
                    return dist;
                }
                for (int r : site2Routes.get(s)) {
                    if (visitedRoutes.add(r)) {
                        for (int t : routes[r]) { // from site s to site t on route r
                            queue.offer(t);
                        }
                    }
                }
            }
        }
        return -1;
    }
}