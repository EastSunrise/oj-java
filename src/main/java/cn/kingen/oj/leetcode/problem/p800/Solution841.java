package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;


/**
 * <a href="https://leetcode.cn/problems/keys-and-rooms/">841. Keys and Rooms</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution261
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH},
        difficulty = Difficulty.MEDIUM
)
public class Solution841 {

    @Complexity(time = "O(n+m)", space = "O(n)", note = "n is the number of rooms and m is the number of keys")
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        return dfs(rooms, new boolean[n], 0) == n;
    }

    private int dfs(List<List<Integer>> rooms, boolean[] visited, int u) {
        if (visited[u]) {
            return 0;
        }
        visited[u] = true;
        int cnt = 1;
        for (int v : rooms.get(u)) {
            cnt += dfs(rooms, visited, v);
        }
        return cnt;
    }
}