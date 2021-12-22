package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 999. Available Captures for Rook (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/available-captures-for-rook/">Available Captures
 * for Rook</a>
 */
public class Solution999 implements Solution {

    public int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        boolean found = false;
        while (x < 8) {
            y = 0;
            while (y < 8) {
                if (board[x][y] == 'R') {
                    found = true;
                    break;
                }
                y++;
            }
            if (found) {
                break;
            }
            x++;
        }
        int res = 0;
        int i = x - 1;
        while (i >= 0 && board[i][y] == '.') {
            i--;
        }
        if (i >= 0 && board[i][y] == 'p') {
            res++;
        }
        i = x + 1;
        while (i < 8 && board[i][y] == '.') {
            i++;
        }
        if (i < 8 && board[i][y] == 'p') {
            res++;
        }

        int j = y - 1;
        while (j >= 0 && board[x][j] == '.') {
            j--;
        }
        if (j >= 0 && board[x][j] == 'p') {
            res++;
        }
        j = y + 1;
        while (j < 8 && board[x][j] == '.') {
            j++;
        }
        if (j < 8 && board[x][j] == 'p') {
            res++;
        }
        return res;
    }
}
