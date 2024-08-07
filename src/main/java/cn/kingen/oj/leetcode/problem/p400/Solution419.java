package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/battleships-in-a-board/">419. Battleships in a Board</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution419 {

    /**
     * Counts only if it's the head of a battleship.
     */
    @Complexity(time = "O(mn)", space = "O(1)")
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }
}