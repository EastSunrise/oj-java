package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 36. Valid Sudoku (Medium)
 *
 * @author Kingen
 * @see Solution37
 * @see <a href="https://leetcode-cn.com/problems/valid-sudoku/">Valid Sudoku</a>
 */
class Solution36 implements Solution {

    /**
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_N
     */
    public boolean isValidSudoku(char[][] board) {
        // rows and columns
        boolean[] rows = new boolean[10];
        boolean[] columns = new boolean[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (rows[ch - '0']) {
                        return false;
                    }
                    rows[ch - '0'] = true;
                }
                ch = board[j][i];
                if (ch != '.') {
                    if (columns[ch - '0']) {
                        return false;
                    }
                    columns[ch - '0'] = true;
                }
            }
            Arrays.fill(rows, false);
            Arrays.fill(columns, false);
        }
        // sub-boxes
        boolean[] stat = new boolean[10];
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                int xm = x + 3, ym = y + 3;
                for (int i = x; i < xm; i++) {
                    for (int j = y; j < ym; j++) {
                        char ch = board[i][j];
                        if (ch != '.') {
                            int idx = ch - '0';
                            if (stat[idx]) {
                                return false;
                            }
                            stat[idx] = true;
                        }
                    }
                }
                Arrays.fill(stat, false);
            }
        }
        return true;
    }
}
