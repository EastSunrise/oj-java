package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/stone-game-vi/">1686. Stone Game VI</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution877
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1140
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1406
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1510
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1563
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1690
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1872
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2029
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.MATH, Tag.GAME_THEORY, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1686 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] values = new int[n][3];
        for (int i = 0; i < n; i++) {
            values[i][0] = aliceValues[i];
            values[i][1] = bobValues[i];
            values[i][2] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(values, (o1, o2) -> o2[2] - o1[2]);
        int dif = 0;
        for (int i = 0; i < n; i++) {
            dif += i % 2 == 0 ? values[i][0] : -values[i][1];
        }
        return dif == 0 ? 0 : dif / Math.abs(dif);
    }
}