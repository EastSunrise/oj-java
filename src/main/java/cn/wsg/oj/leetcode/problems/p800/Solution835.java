package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 835. Image Overlap (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/image-overlap/">Image Overlap</a>
 */
public class Solution835 implements Solution {

    /**
     * @complexity T=O(n^4)
     * @complexity S=O(1)
     */
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;
        for (int dr = 1 - n; dr < n; dr++) {
            int rs = Math.max(dr, 0), re = Math.min(dr + n, n);
            for (int dc = 1 - n; dc < n; dc++) {
                int cs = Math.max(dc, 0), ce = Math.min(dc + n, n);
                int overlap = 0;
                for (int r = rs; r < re; r++) {
                    for (int c = cs; c < ce; c++) {
                        if (img1[r][c] == 1 && img2[r - dr][c - dc] == 1) {
                            overlap++;
                        }
                    }
                }
                max = Math.max(max, overlap);
            }
        }
        return max;
    }
}
