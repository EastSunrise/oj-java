package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 782. Transform to Chessboard (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/transform-to-chessboard/">Transform to
 * Chessboard</a>
 */
public class Solution782 implements Solution {

    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int ones = 0;
        for (int j = 0; j < n; j++) {
            ones += board[0][j];
        }
        int zeros = n - ones;
        if (Math.abs(ones - zeros) > 1) {
            return -1;
        }
        int different = 0;
        for (int i = 1; i < n; i++) {
            int xor = board[i][0] ^ board[0][0];
            for (int j = 1; j < n; j++) {
                if ((board[i][j] ^ board[0][j]) != xor) {
                    return -1;
                }
            }
            different += xor;
        }
        if (ones == zeros) {
            if (different != ones) {
                return -1;
            }
            return Math.min(count(board, 1, 0, n), count(board, 0, 1, n));
        }
        return different == zeros ? count(board, 1, 0, n) : count(board, 0, 1, n);
    }

    private int count(int[][] board, int first, int second, int n) {
        int even = first, odd = second, count = 0;
        while (even < n && odd < n) {
            if (board[0][even] == 1) {
                even += 2;
            } else if (board[0][odd] == 0) {
                odd += 2;
            } else {
                count++;
                even += 2;
                odd += 2;
            }
        }
        even = first;
        odd = second;
        while (even < n && odd < n) {
            if (board[even][0] == 1) {
                even += 2;
            } else if (board[odd][0] == 0) {
                odd += 2;
            } else {
                count++;
                even += 2;
                odd += 2;
            }
        }
        return count;
    }
}
