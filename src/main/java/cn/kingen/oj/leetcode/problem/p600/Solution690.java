package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/employee-importance/">690. Employee Importance</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution339
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class Solution690 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        int sum = 0;
        while (!queue.isEmpty()) {
            Employee employee = map.get(queue.poll());
            sum += employee.importance;
            for (int subordinate : employee.subordinates) {
                queue.offer(subordinate);
            }
        }
        return sum;
    }
}