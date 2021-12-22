package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution463;

/**
 * 733. Flood Fill (EASY)
 *
 * @author Kingen
 * @see Solution463
 * @see <a href="https://leetcode-cn.com/problems/flood-fill/">Flood Fill</a>
 */
public class Solution733 implements Solution {

    /**
     * @see #DFS
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int r, int c, int targetColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != targetColor) {
            return;
        }
        image[r][c] = newColor;
        fill(image, r - 1, c, targetColor, newColor);
        fill(image, r + 1, c, targetColor, newColor);
        fill(image, r, c - 1, targetColor, newColor);
        fill(image, r, c + 1, targetColor, newColor);
    }
}
