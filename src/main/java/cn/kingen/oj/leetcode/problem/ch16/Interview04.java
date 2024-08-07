package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/tic-tac-toe-lcci/">面试题 16.04. Tic-Tac-Toe LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.COUNTING, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Interview04 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public String tictactoe(String[] board) {
        int n = board.length;
        boolean pending = false;
        for (int i = 0; i < n; i++) { // check rows
            char row = check(board, n, i, 0, 0, 1);
            if (row == 'X' || row == 'O') {
                return row + "";
            }
            pending |= row == ' ';
        }
        for (int j = 0; j < n; j++) { // check columns
            char col = check(board, n, 0, 1, j, 0);
            if (col == 'X' || col == 'O') {
                return col + "";
            }
            pending |= col == ' ';
        }
        // check diagonals
        char backslash = check(board, n, 0, 1, 0, 1);
        if (backslash == 'X' || backslash == 'O') {
            return backslash + "";
        }
        pending |= backslash == ' ';
        char slash = check(board, n, 0, 1, n - 1, -1);
        if (slash == 'X' || slash == 'O') {
            return slash + "";
        }
        pending |= slash == ' ';
        return pending ? "Pending" : "Draw";
    }

    /**
     * @return ' ' represents pending, 'X' or 'O' represents winner, otherwise represents no winner
     */
    private char check(String[] board, int n, int i, int di, int j, int dj) {
        char p = '#';
        for (int k = 0; k < n; k++) {
            char ch = board[i].charAt(j);
            if (ch == ' ') {
                return ch;
            } else if (p == '#') {
                p = ch;
            } else if (p != ch) {
                p = '#';
                break;
            }
            i += di;
            j += dj;
        }
        return p;
    }
}