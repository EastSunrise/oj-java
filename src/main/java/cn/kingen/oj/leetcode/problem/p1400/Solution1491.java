package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/">1491. Average Salary Excluding the Minimum and Maximum Salary</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution1491 {

    @Complexity(time = "O(n)", space = "O(1)")
    public double average(int[] salary) {
        int max = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int s : salary) {
            max = Math.max(max, s);
            min = Math.min(min, s);
            sum += s;
        }
        return (sum - max - min) * 1.0 / (salary.length - 2);
    }
}