package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 79. Word Search (Medium)
 *
 * @author Kingen
 * @see Solution212
 * @see <a href="https://leetcode-cn.com/problems/word-search/">Word Search</a>
 * @since 2021-07-11
 */
class Solution79 implements Solution {

    /**
     * @complexity T=O(mnl), l=len(word)
     * @complexity S=O(l)
     * @see #BACKTRACKING
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length - 1, n = board[0].length - 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (exist(board, m, n, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param m the maximum that i can be
     * @param n the maximum that j can be
     * @param i the row of the char to be compared
     * @param j the column of the char to be compared
     * @param k the index of the char to be found
     */
    private boolean exist(char[][] board, int m, int n, int i, int j, char[] chars, int k) {
        char ch = chars[k];
        if (board[i][j] != ch) {
            return false;
        }
        k++;
        if (k == chars.length) {
            // all found
            return true;
        }
        // used
        board[i][j] = '#';
        if (i > 0 && exist(board, m, n, i - 1, j, chars, k)) {
            return true;
        }
        if (j > 0 && exist(board, m, n, i, j - 1, chars, k)) {
            return true;
        }
        if (i < m && exist(board, m, n, i + 1, j, chars, k)) {
            return true;
        }
        if (j < n && exist(board, m, n, i, j + 1, chars, k)) {
            return true;
        }
        // restore the char
        board[i][j] = ch;
        return false;
    }
}
