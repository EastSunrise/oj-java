package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/transform-to-chessboard/">782. Transform to Chessboard</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3189

 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.MATH, Tag.MATRIX},
    difficulty = Difficulty.HARD
)
public class Solution782 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public int movesToChessboard(int[][] board) {
        int n = board.length, mask = (1 << n) - 1;
        if (!check(board, n, mask)) {
            return -1;
        }

        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == board[i][0]) { // not need to move
                rowCnt++;
            }
        }
        for (int j = 0; j < n; j++) {
            if ((j & 1) == board[0][j]) { // not need to move
                colCnt++;
            }
        }
        if ((n & 1) == 0) {
            rowCnt = Math.min(rowCnt, n - rowCnt);
            colCnt = Math.min(colCnt, n - colCnt);
        } else {
            rowCnt = (rowCnt & 1) == 0 ? rowCnt : n - rowCnt;
            colCnt = (colCnt & 1) == 0 ? colCnt : n - colCnt;
        }
        return (rowCnt + colCnt) / 2;
    }

    private boolean check(int[][] board, int n, int mask) {
        int row0 = 0, col0 = 0;
        for (int i = 0; i < n; i++) {
            row0 = row0 << 1 | board[0][i];
            col0 = col0 << 1 | board[i][0];
        }
        int rowOnes = Integer.bitCount(row0), colOnes = Integer.bitCount(col0);
        if (Math.abs(rowOnes - (n - rowOnes)) > 1 || Math.abs(colOnes - (n - colOnes)) > 1) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < n; j++) {
                row = row << 1 | board[i][j];
                col = col << 1 | board[j][i];
            }
            if (row != row0 && (row ^ row0) != mask) {
                return false;
            }
            if (col != col0 && (col ^ col0) != mask) {
                return false;
            }
        }
        return true;
    }
}