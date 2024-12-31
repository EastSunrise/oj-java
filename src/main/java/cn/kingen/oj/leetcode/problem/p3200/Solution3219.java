package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-for-cutting-cake-ii/">3219. Minimum Cost for Cutting Cake II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3218
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.HARD,
        daily = "2024-12-31"
)
public class Solution3219 {

    /**
     * Regards the problem as a minimum spanning tree problem.
     */
    @Complexity(time = "O(m*log(m)+n*log(n))", space = "O(1)")
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        long ans = 0;
        for (int i = 0, j = 0; i < m - 1 || j < n - 1; ) {
            if (j == n - 1 || i < m - 1 && horizontalCut[i] < verticalCut[j]) {
                ans += (long) horizontalCut[i++] * (n - j);
            } else {
                ans += (long) verticalCut[j++] * (m - i);
            }
        }
        return ans;
    }
}