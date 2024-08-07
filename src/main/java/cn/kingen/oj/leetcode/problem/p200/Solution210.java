package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/course-schedule-ii/">210. Course Schedule II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution207
 * @see cn.kingen.oj.leetcode.problem.p200.Solution269
 * @see cn.kingen.oj.leetcode.problem.p300.Solution310
 * @see cn.kingen.oj.leetcode.problem.p400.Solution444
 * @see cn.kingen.oj.leetcode.problem.p600.Solution630
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1136
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2115
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2392
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2459
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.TOPOLOGICAL_SORT},
        difficulty = Difficulty.MEDIUM
)
public class Solution210 {

    @Complexity(time = "O(|V|+|E|)", space = "O(|V|+|E|)", note = "|V| is the number of courses, |E| is the number of prerequisites")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int a = edge[0], b = edge[1];
            graph.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int i = 0;
        for (; !queue.isEmpty(); i++) {
            int a = queue.poll();
            ans[i] = a;
            for (int b : graph.get(a)) {
                inDegree[b]--;
                if (inDegree[b] == 0) {
                    queue.offer(b);
                }
            }
        }
        return i == numCourses ? ans : new int[0];
    }
}