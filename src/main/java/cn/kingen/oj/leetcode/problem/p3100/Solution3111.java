package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/minimum-rectangles-to-cover-points/">3111. Minimum Rectangles to Cover Points</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution939
 * @see cn.kingen.oj.leetcode.problem.p900.Solution973
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3111 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int right = -1, cnt = 0;
        for (int[] point : points) {
            if (point[0] > right) {
                right = point[0] + w;
                cnt++;
            }
        }
        return cnt;
    }
}