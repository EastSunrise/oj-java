package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 661. Image Smoother (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/image-smoother/">Image Smoother</a>
 * @since 2021-07-23
 */
class Solution661 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j], count = 1;
                for (int k = 0; k < 8; k++) {
                    int x = i + di[k], y = j + dj[k];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += img[x][y];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
