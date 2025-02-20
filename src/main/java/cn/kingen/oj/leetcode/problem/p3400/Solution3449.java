package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximize-the-minimum-game-score/">3449. Maximize the Minimum Game Score</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.HARD,
        contest = 436
)
public class Solution3449 {

    @Complexity(time = "O(n*log(U))", space = "O(1)", note = "U is the range of possible scores")
    public long maxScore(int[] points, int m) {
        long min = Long.MAX_VALUE;
        for (int point : points) {
            min = Math.min(min, point);
        }

        long low = 0, high = (m + 1) / 2 * min + 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(points, m, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean check(int[] points, int m, long limit) {
        long ops = 0, score = 0;
        for (int i = 0, j = -1; i < points.length; i++) {
            if (score >= limit) {
                score = 0;
                continue;
            }

            long k = (limit - score - 1) / points[i] + 1;
            ops += i - j + (k - 1) * 2;
            if (i < points.length - 1) {
                score = (k - 1) * points[i + 1];
            }
            j = i;

            if (ops > m) {
                return false;
            }
        }
        return true;
    }
}