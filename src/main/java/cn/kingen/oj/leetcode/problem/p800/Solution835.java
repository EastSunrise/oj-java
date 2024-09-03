package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/image-overlap/">835. Image Overlap</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution835 {

    @Complexity(time = "O(n^4)", space = "O(1)")
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
                        if ((img1[r][c] & img2[r - dr][c - dc]) == 1) {
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