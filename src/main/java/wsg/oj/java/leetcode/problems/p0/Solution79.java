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
public class Solution79 implements Solution {

    /**
     * @complexity T=O(mnl), l=len(word)
     * @complexity S=O(l)
     * @see #BACKTRACKING
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param i the row of the char to be compared
     * @param j the column of the char to be compared
     * @param k the index of the char to be found
     */
    private boolean exist(char[][] board, int i, int j, char[] word, int k) {
        if (k == word.length) {
            // all found
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word[k]) {
            return false;
        }
        // used
        board[i][j] = '#';
        if (exist(board, i - 1, j, word, k + 1)) {
            return true;
        }
        if (exist(board, i, j - 1, word, k + 1)) {
            return true;
        }
        if (exist(board, i + 1, j, word, k + 1)) {
            return true;
        }
        if (exist(board, i, j + 1, word, k + 1)) {
            return true;
        }
        // restore the char
        board[i][j] = word[k];
        return false;
    }
}
