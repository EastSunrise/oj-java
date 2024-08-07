package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/diving-board-lcci/">面试题 16.11. Diving Board LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Interview11 {

    @Complexity(time = "O(k)", space = "O(k)")
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] ans = new int[k + 1];
        ans[0] = shorter * k;
        int dif = longer - shorter;
        for (int i = 1; i <= k; i++) {
            ans[i] = ans[i - 1] + dif;
        }
        return ans;
    }
}