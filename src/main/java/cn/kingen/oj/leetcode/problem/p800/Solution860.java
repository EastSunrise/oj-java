package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/lemonade-change/">860. Lemonade Change</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY},
        difficulty = Difficulty.EASY,
        contest = 91
)
public class Solution860 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                count10++;
                count5--;
            } else if (count10 > 0) {
                count10--;
                count5--;
            } else {
                count5 -= 3;
            }
            if (count5 < 0) {
                return false;
            }
        }
        return true;
    }
}