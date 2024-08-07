package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.ArrayUtils.EIGHT_DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/check-if-move-is-legal/">1958. Check if Move is Legal</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.ENUMERATION, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution1958 {

    @Complexity(time = "O(m+n)", space = "O(1)")
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int[] d : EIGHT_DIRECTIONS) {
            if (check(board, rMove, cMove, color, d[0], d[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, int rMove, int cMove, char color, int dr, int dc) {
        int r = rMove + dr, c = cMove + dc, len = 2;
        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
            if (board[r][c] == '.') {
                return false;
            }
            if (board[r][c] == color) {
                return len >= 3;
            }
            r += dr;
            c += dc;
            len++;
        }
        return false;
    }
}