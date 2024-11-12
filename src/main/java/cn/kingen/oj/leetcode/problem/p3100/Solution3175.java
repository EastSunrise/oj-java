package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/">3175. Find The First Player to win K Games in a Row</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution3175 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int winner = 0, cnt = 0;
        for (int i = 1; i < n; i++) {
            if (skills[i] > skills[winner]) { // new winner
                winner = i;
                cnt = 1;
            } else {
                cnt++;
            }
            if (cnt >= k) {
                return winner;
            }
        }
        return winner;
    }
}