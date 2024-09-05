package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximize-distance-to-closest-person/">849. Maximize Distance to Closest Person</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.ExamRoom
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2365
 */
@Question(tags = {Tag.ARRAY}, difficulty = Difficulty.MEDIUM)
public class Solution849 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxDistToClosest(int[] seats) {
        int p = 0, n = seats.length;
        while (p < n && seats[p] == 0) { // find the first occupied seat
            p++;
        }
        int distance = p;
        for (; ; ) {
            int i = p + 1;
            while (i < n && seats[i] == 0) { // find the next occupied seat
                i++;
            }
            if (i == n) {
                return Math.max(distance, n - p - 1);
            }
            distance = Math.max(distance, (i - p) / 2);
            p = i;
        }
    }
}