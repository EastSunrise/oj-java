package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p900.Solution980;

/**
 * 37. Sudoku Solver (HARD)
 *
 * @author Kingen
 * @see Solution36
 * @see Solution980
 * @see <a href="https://leetcode-cn.com/problems/sudoku-solver/">Sudoku Solver</a>
 */
public class Solution37 implements Solution {

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    rows[i][n] = cols[j][n] = boxes[i / 3 * 3 + j / 3][n] = true;
                }
            }
        }
        fill(board, 0, 0, rows, cols, boxes);
    }

    private boolean fill(char[][] board, int r, int c,
        boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        if (c == 9) {
            // next row
            c = 0;
            r++;
        }
        if (r == 9) {
            // finished
            return true;
        }
        if (board[r][c] != '.') {
            // filled
            return fill(board, r, c + 1, rows, cols, boxes);
        }
        boolean[] row = rows[r];
        boolean[] col = cols[c];
        boolean[] box = boxes[r / 3 * 3 + c / 3];
        for (char n = 0; n < 9; n++) {
            if (row[n] || col[n] || box[n]) {
                continue;
            }
            // try to fill board[r][c] with n
            board[r][c] = (char) (n + '1');
            row[n] = col[n] = box[n] = true;
            // try to fill next cell
            if (fill(board, r, c + 1, rows, cols, boxes)) {
                // all next cells are filled correctly
                return true;
            }
            // roll back
            board[r][c] = '.';
            row[n] = col[n] = box[n] = false;
        }
        // can't fill
        return false;
    }
}
