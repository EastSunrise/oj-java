package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-winner-of-an-array-game/">1535. Find the Winner of an Array Game</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution1535 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int winner = arr[0], count = 0;
        for (int i = 1; i < n && count < k; i++) {
            if (arr[i] > winner) {
                winner = arr[i];
                count = 1;
            } else {
                count++;
            }
        }
        return winner;
    }
}