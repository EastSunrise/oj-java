package cn.kingen.oj.leetcode.problem.lcp;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/6CE719/">LCP 61. 气温变化趋势</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Lcp061 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int cnt = 0, max = 0;
        for (int i = 1; i < n; i++) {
            int a = Integer.compare(temperatureA[i], temperatureA[i - 1]);
            int b = Integer.compare(temperatureB[i], temperatureB[i - 1]);
            if (a == b) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        return Math.max(max, cnt);
    }
}