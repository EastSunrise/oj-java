package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-employees-who-met-the-target/">2798. Number of Employees Who Met the Target</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution2798 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target) {
                ans++;
            }
        }
        return ans;
    }
}