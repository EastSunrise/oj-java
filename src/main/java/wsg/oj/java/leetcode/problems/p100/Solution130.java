package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 130. Surrounded Regions (Medium)
 *
 * @author Kingen
 * @see Solution200
 * @see Solution286
 * @see <a href="https://leetcode-cn.com/problems/surrounded-regions/">Surrounded Regions</a>
 * @since 2021-07-11
 */
class Solution130 implements Solution {

    /**
     * @complexity T=O(lmn), l=average length of consecutive 'O's
     * @complexity S=O(l)
     * @see #DFS
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // the first and last columns
        for (int i = 0; i < m; i++) {
            flip(board, i, 0);
        }
        if (n > 1) {
            int j = n - 1;
            for (int i = 0; i < m; i++) {
                flip(board, i, j);
            }
        }
        // the first and last rows
        for (int j = 0; j < n; j++) {
            flip(board, 0, j);
        }
        if (m > 1) {
            int i = m - 1;
            for (int j = 0; j < n; j++) {
                flip(board, i, j);
            }
        }
        // flip all left 'O's
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
