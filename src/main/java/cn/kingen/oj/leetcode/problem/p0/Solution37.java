package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/">37. Sudoku Solver</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution36
 * @see cn.kingen.oj.leetcode.problem.p900.Solution980
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.BACKTRACKING, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution37 {

    @Complexity(time = "#", space = "#")
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9];
        int[][] boxes = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int v = 1 << (board[i][j] - '1');
                    rows[i] |= v;
                    cols[j] |= v;
                    boxes[i / 3][j / 3] |= v;
                }
            }
        }
        fill(board, 0, 0, rows, cols, boxes);
    }

    private boolean fill(char[][] board, int i, int j, int[] rows, int[] cols, int[][] boxes) {
        if (j == 9) { // next row
            j = 0;
            i++;
        }
        if (i == 9) { // finished
            return true;
        }
        if (board[i][j] != '.') { // filled
            return fill(board, i, j + 1, rows, cols, boxes);
        }
        int row = rows[i], col = cols[j], box = boxes[i / 3][j / 3];
        for (int k = 0; k < 9; k++) {
            int v = 1 << k;
            if ((row & v) > 0 || (col & v) > 0 || (box & v) > 0) { // used
                continue;
            }
            // try to fill board[i][j] with k
            board[i][j] = (char) (k + '1');
            rows[i] |= v;
            cols[j] |= v;
            boxes[i / 3][j / 3] |= v;
            if (fill(board, i, j + 1, rows, cols, boxes)) { // try to fill next cell
                // all next cells are filled correctly
                return true;
            }
            // roll back and try next value
            board[i][j] = '.';
            rows[i] &= ~v;
            cols[j] &= ~v;
            boxes[i / 3][j / 3] &= ~v;
        }
        return false; // all failed
    }
}