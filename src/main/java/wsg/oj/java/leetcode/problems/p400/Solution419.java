package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 419. Battleships in a Board (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/battleships-in-a-board/">Battleships in a
 * Board</a>
 * @since 2021-07-07
 */
class Solution419 implements Solution {

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        // only count the head of a battleship
        int count = 0;
        if (board[0][0] == 'X') {
            count++;
        }
        for (int i = 1; i < m; i++) {
            if (board[i][0] == 'X' && board[i - 1][0] != 'X') {
                count++;
            }
        }
        for (int j = 1; j < n; j++) {
            if (board[0][j] == 'X' && board[0][j - 1] != 'X') {
                count++;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 'X' && board[i - 1][j] != 'X' && board[i][j - 1] != 'X') {
                    count++;
                }
            }
        }
        return count;
    }
}
