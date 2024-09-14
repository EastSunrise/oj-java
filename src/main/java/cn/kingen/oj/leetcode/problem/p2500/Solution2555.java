package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximize-win-from-two-segments/">2555. Maximize Win From Two Segments</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution123
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2054
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution2555 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        if (prizePositions[n - 1] - prizePositions[0] <= k * 2 + 1) {
            return n;
        }
        int i = 0, j = 0;
        int firstMax = 0, totalMax = 0;
        for (int p = 1, q = 1; q < n; q++) { // second window: [p, q]
            while (prizePositions[q] - prizePositions[p] > k) {
                p++;
            }
            for (; j < p; j++) { // first window: [i, j]
                while (prizePositions[j] - prizePositions[i] > k) {
                    i++;
                }
                firstMax = Math.max(firstMax, j - i + 1);
            }
            totalMax = Math.max(totalMax, q - p + 1 + firstMax);
        }
        return totalMax;
    }
}