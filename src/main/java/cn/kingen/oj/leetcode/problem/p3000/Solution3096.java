package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-levels-to-gain-more-points/">3096. Minimum Levels to Gain More Points</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2244
 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution3096 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minimumLevels(int[] possible) {
        int sum = 0;
        for (int level : possible) {
            sum += level == 1 ? 1 : -1;
        }
        int alice = 0;
        for (int i = 0, n = possible.length - 1; i < n; i++) {
            alice += possible[i] == 1 ? 1 : -1;
            if (alice > sum - alice) {
                return i + 1;
            }
        }
        return -1;
    }
}