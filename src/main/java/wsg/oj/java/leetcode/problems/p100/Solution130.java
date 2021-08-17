package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution200;

/**
 * 130. Surrounded Regions (Medium)
 *
 * @author Kingen
 * @see Solution200
 * @see Solution286
 * @see <a href="https://leetcode-cn.com/problems/surrounded-regions/">Surrounded Regions</a>
 * @since 2021-07-11
 */
public class Solution130 implements Solution {

    /**
     * @complexity T=O(lmn), l=average length of consecutive 'O's
     * @complexity S=O(l)
     * @see #DFS
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // the first column
        for (int i = 0; i < m; i++) {
            flip(board, i, 0);
        }
        // the last column
        for (int i = 0; i < m; i++) {
            flip(board, i, n - 1);
        }
        // the first row
        for (int j = 0; j < n; j++) {
            flip(board, 0, j);
        }
        // the last row
        for (int j = 0; j < n; j++) {
            flip(board, m - 1, j);
        }

        // flip all inner 'O's
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        // flip 'N's back to 'O's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flip(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            // out of range
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        // mark as not-flipped
        board[i][j] = 'N';
        flip(board, i - 1, j);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
        flip(board, i, j + 1);
    }
}
