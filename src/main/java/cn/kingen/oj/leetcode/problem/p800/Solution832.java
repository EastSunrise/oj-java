package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/flipping-an-image/">832. Flipping an Image</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.TWO_POINTERS, Tag.MATRIX, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution832 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length, tmp;
        for (int[] row : image) {
            int low = 0, high = row.length - 1;
            while (low < high) {
                tmp = row[low];
                row[low++] = row[high] ^ 1;
                row[high--] = tmp ^ 1;
            }
        }
        if ((n & 1) == 1) {
            int mid = n / 2;
            for (int[] row : image) {
                row[mid] = row[mid] ^ 1;
            }
        }
        return image;
    }
}