package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 51. N-Queens (HARD)
 *
 * @author Kingen
 * @see Solution52
 * @see Solution1001
 * @see <a href="https://leetcode-cn.com/problems/n-queens/">N-Queens</a>
 * @since 2021-07-18
 */
class Solution51 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NF
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        boolean[] cols = new boolean[n];
        boolean[] tl2br = new boolean[2 * n - 1], tr2bl = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<>();
        place(res, n, 0, board, cols, tl2br, tr2bl);
        return res;
    }

    /**
     * Chooses a cell in the row to place a queen.
     *
     * @param row the row where the queen will be placed
     */
    private void place(List<List<String>> res, int n, int row, char[][] board,
        boolean[] cols, boolean[] tl2br, boolean[] tr2bl) {
        if (row == n) {
            List<String> list = new ArrayList<>(n);
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col]) {
                continue;
            }
            int tl = row + n - 1 - col;
            int tr = row + col;
            if (tl2br[tl] || tr2bl[tr]) {
                continue;
            }
            // place a queen at [row,col]
            board[row][col] = 'Q';
            cols[col] = tl2br[tl] = tr2bl[tr] = true;
            // place a queen at next row
            place(res, n, row + 1, board, cols, tl2br, tr2bl);
            // roll back
            board[row][col] = '.';
            cols[col] = tl2br[tl] = tr2bl[tr] = false;
        }
    }
}
