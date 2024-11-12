package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/">3185. Count Pairs That Form a Complete Day II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1010
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1497
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3185 {

    @Complexity(time = "O(Cn)", space = "O(C)", note = "C is 24")
    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        int[] count = new int[24];
        for (int hour : hours) {
            hour %= 24;
            ans += hour == 0 ? count[0] : count[24 - hour];
            count[hour]++;
        }
        return ans;
    }
}