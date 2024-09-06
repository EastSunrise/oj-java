package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/count-days-without-meetings/">3169. Count Days Without Meetings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution56
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3169 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int ans = 0, end = 0;
        for (int[] meeting : meetings) {
            int start = meeting[0], stop = meeting[1];
            if (start > end) {
                ans += start - end - 1;
            }
            end = Math.max(end, stop);
        }
        return ans + days - end;
    }
}