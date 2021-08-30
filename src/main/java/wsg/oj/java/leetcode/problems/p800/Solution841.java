package wsg.oj.java.leetcode.problems.p800;

import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 841. Keys and Rooms (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/keys-and-rooms/">Keys and Rooms</a>
 * @since 2021-07-27
 */
public class Solution841 implements Solution {

    /**
     * @see #DFS
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for (boolean reachable : visited) {
            if (!reachable) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int u) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        for (int v : rooms.get(u)) {
            dfs(rooms, visited, v);
        }
    }
}
