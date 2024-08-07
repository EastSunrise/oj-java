package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/most-profit-assigning-work/">826. Most Profit Assigning Work</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2071
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2300
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2410
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution826 {

    @Complexity(time = "O(n*log{n}+m*log{m})", space = "O(n)")
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        int[][] works = new int[n][2];
        for (int i = 0; i < n; i++) {
            works[i][0] = difficulty[i];
            works[i][1] = profit[i];
        }
        Arrays.sort(works, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);

        int ans = 0, max = 0;
        for (int j = 0, i = 0; j < m; j++) {
            int ability = worker[j];
            while (i < n && works[i][0] <= ability) {
                max = Math.max(max, works[i][1]);
                i++;
            }
            ans += max;
        }
        return ans;
    }
}