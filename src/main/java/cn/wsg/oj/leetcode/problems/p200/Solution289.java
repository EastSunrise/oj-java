package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution73;

/**
 * 289. Game of Life (Medium)
 *
 * @author Kingen
 * @see Solution73
 * @see <a href="https://leetcode-cn.com/problems/game-of-life/">Game of Life</a>
 */
public class Solution289 implements Solution {

    /**
     * Changes the state of board[i][j] to 0bxy: x means the next state of the cell and y means the
     * current state of the cell.
     *
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
     */
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nextState(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>>= 1;
            }
        }
    }

    private void nextState(int[][] board, int i, int j) {
        int lives = 0;
        lives += isLive(board, i - 1, j - 1);
        lives += isLive(board, i, j - 1);
        lives += isLive(board, i + 1, j - 1);
        lives += isLive(board, i - 1, j);
        lives += isLive(board, i + 1, j);
        lives += isLive(board, i - 1, j + 1);
        lives += isLive(board, i, j + 1);
        lives += isLive(board, i + 1, j + 1);
        if (board[i][j] == 0) {
            if (lives == 3) {
                board[i][j] = 2;
            }
        } else {
            if (lives == 2 || lives == 3) {
                board[i][j] = 3;
            }
        }
    }

    private int isLive(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return 0;
        }
        return board[i][j] & 1;
    }
}
