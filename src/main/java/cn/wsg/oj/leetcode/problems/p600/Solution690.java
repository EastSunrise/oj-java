package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690. Employee Importance (EASY)
 *
 * @author Kingen
 * @see Solution339
 * @see <a href="https://leetcode-cn.com/problems/employee-importance/">Employee Importance</a>
 */
public class Solution690 implements Solution {

    /**
     * @complexity T=O(N) N=the number of subordinates of the employee
     * @complexity S=O(M) M=the number of all employees
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> ids = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            ids.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(ids.get(id));
        int res = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.remove();
            res += employee.importance;
            for (int sid : employee.subordinates) {
                queue.add(ids.get(sid));
            }
        }
        return res;
    }

    /**
     * Definition for Employee.
     */
    static class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
