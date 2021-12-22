package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 52. N-Queens II (HARD)
 *
 * @author Kingen
 * @see Solution51
 * @see <a href="https://leetcode-cn.com/problems/n-queens-ii/">N-Queens II</a>
 */
public class Solution52 implements Solution {

    /**
     * @see Complexity#TIME_NF
     * @see Complexity#SPACE_N
     */
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] tl2br = new boolean[2 * n - 1], tr2bl = new boolean[2 * n - 1];
        int count = 0;
        for (int col = 0; col < n / 2; col++) {
            int tl = n - 1 - col;
            cols[col] = tl2br[tl] = tr2bl[col] = true;
            count += 2 * place(n, 1, cols, tl2br, tr2bl);
            cols[col] = tl2br[tl] = tr2bl[col] = false;
        }
        if (n % 2 == 1) {
            int col = n / 2;
            cols[col] = tl2br[col] = tr2bl[col] = true;
            count += place(n, 1, cols, tl2br, tr2bl);
        }
        return count;
    }

    private int place(int n, int row, boolean[] cols, boolean[] tl2br, boolean[] tr2bl) {
        if (row == n) {
            return 1;
        }
        int count = 0;
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
            cols[col] = tl2br[tl] = tr2bl[tr] = true;
            // place a queen at next row
            count += place(n, row + 1, cols, tl2br, tr2bl);
            // roll back
            cols[col] = tl2br[tl] = tr2bl[tr] = false;
        }
        return count;
    }
}
