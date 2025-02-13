package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/">1742. Maximum Number of Balls in a Box</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3160

 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.MATH, Tag.COUNTING},
        difficulty = Difficulty.EASY,
        date = "2025-02-13"
)
public class Solution1742 {

    @Complexity(time = "O(n)", space = "O(k)")
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[50];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0, x = i;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            count[sum]++;
            max = Math.max(max, count[sum]);
        }
        return max;
    }
}