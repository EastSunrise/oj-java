package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/convert-date-to-binary/">3280. Convert Date to Binary</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1017
 */
@Question(
        difficulty = Difficulty.EASY
)
public class Solution3280 {

    @Complexity(time = "O(1)", space = "O(1)")
    public String convertDateToBinary(String date) {
        String year = Integer.toBinaryString(Integer.parseInt(date.substring(0, 4)));
        String month = Integer.toBinaryString(Integer.parseInt(date.substring(5, 7)));
        String day = Integer.toBinaryString(Integer.parseInt(date.substring(8)));
        return year + '-' + month + '-' + day;
    }
}