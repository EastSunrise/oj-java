package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 529. Minesweeper (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minesweeper/">Minesweeper</a>
 */
class Solution529 implements Solution {

    private final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * @see #DFS
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            click(board, r, c);
        }
        return board;
    }

    private void click(char[][] board, int r, int c) {
        if (r < 0 || r == board.length || c < 0 || c == board[0].length) {
            return;
        }
        if (board[r][c] == 'E') {
            // check adjacent mines
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int tr = r + dr[i], tc = c + dc[i];
                if (tr < 0 || tr == board.length || tc < 0 || tc == board[0].length) {
                    continue;
                }
                if (board[tr][tc] == 'M') {
                    count++;
                }
            }
            if (count > 0) {
                board[r][c] = (char) (count + '0');
            } else {
                board[r][c] = 'B';
                for (int i = 0; i < 8; i++) {
                    click(board, r + dr[i], c + dc[i]);
                }
            }
        }
    }
}
