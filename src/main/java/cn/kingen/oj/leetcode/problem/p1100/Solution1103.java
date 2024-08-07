package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/distribute-candies-to-people/">1103. Distribute Candies to People</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2591
 */
@Question(
        tags = {Tag.MATH, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution1103 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] distributeCandies(int candies, int n) {
        int round = 0, start = 1, sum;
        while (candies >= (sum = (start + start + n - 1) * n / 2)) {
            candies -= sum;
            round++;
            start += n;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (i + 1 + start - n + i) * round / 2;
        }
        for (int i = 0; i < n && candies > 0; i++) {
            int x = Math.min(candies, start + i);
            ans[i] += x;
            candies -= x;
        }
        return ans;
    }

}