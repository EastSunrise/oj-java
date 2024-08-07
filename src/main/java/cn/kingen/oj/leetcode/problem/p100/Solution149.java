package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/max-points-on-a-line/">149. Max Points on a Line</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution356
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2152
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2280
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH},
        difficulty = Difficulty.HARD
)
public class Solution149 {

    @Complexity(time = "O(n^3)", space = "O(1)")
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            if (max >= n - i || max > n / 2) {
                return max;
            }
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    int x = points[k][0], y = points[k][1];
                    if ((y - y2) * (x - x1) == (x - x2) * (y - y1)) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}