package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/course-schedule/">207. Course Schedule</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution210
 * @see cn.kingen.oj.leetcode.problem.p200.Solution261
 * @see cn.kingen.oj.leetcode.problem.p300.Solution310
 * @see cn.kingen.oj.leetcode.problem.p600.Solution630
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2392
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.TOPOLOGICAL_SORT},
        difficulty = Difficulty.MEDIUM
)
public class Solution207 extends Solution210 {

    @Complexity(time = "O(|V|+|E|)", space = "O(|V|+|E|)", note = "|V| is the number of courses, |E| is the number of prerequisites")
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return findOrder(numCourses, prerequisites).length == numCourses;
    }
}