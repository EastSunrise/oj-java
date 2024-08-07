package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/number-of-ships-in-a-rectangle/">1274. Number of Ships in a Rectangle</a>
 *
 * @author Kingen
 */
@Question(
        paidOnly = true,
        tags = {Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.INTERACTIVE},
        difficulty = Difficulty.HARD
)
public class Solution1274 {

    @Complexity(time = "#", space = "#")
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }
        int midX = (bottomLeft[0] + topRight[0]) >> 1;
        int midY = (bottomLeft[1] + topRight[1]) >> 1;
        int count = countShips(sea, new int[]{midX, midY}, bottomLeft);
        if (midX < topRight[0]) {
            count += countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
        }
        if (midY < topRight[1]) {
            count += countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});
        }
        if (midX < topRight[0] && midY < topRight[1]) {
            count += countShips(sea, topRight, new int[]{midX + 1, midY + 1});
        }
        return count;
    }
}