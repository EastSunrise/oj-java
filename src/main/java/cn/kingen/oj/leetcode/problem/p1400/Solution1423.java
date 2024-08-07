package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/">1423. Maximum Points You Can Obtain from Cards</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1770
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2091
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2379
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2931
 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution1423 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, winLen = n - k;
        int sum = 0;
        for (int i = 0; i < winLen; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum, total = sum;
        for (int i = winLen; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - winLen];
            minSum = Math.min(minSum, sum);
            total += cardPoints[i];
        }
        return total - minSum;
    }
}