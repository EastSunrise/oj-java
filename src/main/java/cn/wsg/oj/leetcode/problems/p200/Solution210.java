package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution310;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 210. Course Schedule II (Medium)
 *
 * @author Kingen
 * @see Solution207
 * @see Solution269
 * @see Solution310
 * @see Solution444
 * @see Solution630
 * @see Solution1136
 * @see <a href="https://leetcode-cn.com/problems/course-schedule-ii/">Course Schedule II</a>
 */
public class Solution210 extends Solution207 implements Solution {

    /**
     * @complexity T=O(|E|)
     * @complexity S=O(|V|+|E|)
     * @see #DFS
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = Arrays.stream(prerequisites)
            .collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> a[1],
                Collectors.toList())));
        Set<Integer> finished = new LinkedHashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(edges, finished, new HashSet<>(), i)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        for (int course : finished) {
            res[i++] = course;
        }
        return res;
    }
}
