package wsg.oj.java.leetcode.problems.p200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution310;

/**
 * 207. Course Schedule (Medium)
 *
 * @author Kingen
 * @see Solution210
 * @see Solution261
 * @see Solution310
 * @see Solution630
 * @see <a href="https://leetcode-cn.com/problems/course-schedule/">Course Schedule</a>
 * @since 2021-07-12
 */
public class Solution207 implements Solution {

    /**
     * Checks whether the graph has a cycle.
     *
     * @complexity T=O(|E|)
     * @complexity S=O(L), L=the average length of all paths
     * @see #DFS
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = Arrays.stream(prerequisites)
            .collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> a[1],
                Collectors.toList())));
        Set<Integer> finished = new HashSet<>(numCourses);
        for (int end : edges.keySet()) {
            if (!canFinish(edges, finished, new HashSet<>(), end)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finishes the target.
     *
     * @param edges     all edges in the graph
     * @param finished  courses that have been finished
     * @param finishing the courses being finished
     * @param target    the course to be finished
     */
    protected boolean canFinish(Map<Integer, List<Integer>> edges, Set<Integer> finished,
        Set<Integer> finishing, int target) {
        if (finishing.contains(target)) {
            return false;
        }
        List<Integer> starts = edges.get(target);
        if (starts != null) {
            finishing.add(target);
            for (int start : starts) {
                if (!finished.contains(start) && !canFinish(edges, finished, finishing, start)) {
                    return false;
                }
            }
            finishing.remove(target);
        }
        finished.add(target);
        return true;
    }
}
