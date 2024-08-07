package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimize-manhattan-distances/">3102. Minimize Manhattan Distances</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.ARRAY, Tag.MATH, Tag.ORDERED_SET, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution3102 {

    /**
     * Converts Manhattan distance to Chebyshe distance.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int minimumDistance(int[][] points) {
        int n = points.length;
        int max1x = Integer.MIN_VALUE, max2x = Integer.MIN_VALUE, max1y = Integer.MIN_VALUE, max2y = Integer.MIN_VALUE;
        int min1x = Integer.MAX_VALUE, min2x = Integer.MAX_VALUE, min1y = Integer.MAX_VALUE, min2y = Integer.MAX_VALUE;
        int maxXi = 0, maxYi = 0, minXi = 0, minYi = 0;
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            int x = point[0] - point[1], y = point[0] + point[1];

            if (x > max1x) {
                max2x = max1x;
                max1x = x;
                maxXi = i;
            } else if (x > max2x) {
                max2x = x;
            }
            if (x < min1x) {
                min2x = min1x;
                min1x = x;
                minXi = i;
            } else if (x < min2x) {
                min2x = x;
            }
            if (y > max1y) {
                max2y = max1y;
                max1y = y;
                maxYi = i;
            } else if (y > max2y) {
                max2y = y;
            }
            if (y < min1y) {
                min2y = min1y;
                min1y = y;
                minYi = i;
            } else if (y < min2y) {
                min2y = y;
            }
        }

        int ans = Integer.MAX_VALUE;
        int[] removed = new int[]{maxXi, maxYi, minXi, minYi};
        for (int i : removed) {
            int dx = (i == maxXi ? max2x : max1x) - (i == minXi ? min2x : min1x);
            int dy = (i == maxYi ? max2y : max1y) - (i == minYi ? min2y : min1y);
            ans = Math.min(ans, Math.max(dx, dy));
        }
        return ans;
    }
}