package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 832. Flipping an Image (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/flipping-an-image/">Flipping an Image</a>
 * @since 2021-07-27
 */
public class Solution832 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int left = 0, right = row.length - 1;
            while (left < right) {
                int tmp = row[left];
                row[left++] = row[right] ^ 1;
                row[right--] = tmp ^ 1;
            }
        }
        if ((image[0].length & 1) == 1) {
            int mid = image[0].length / 2;
            for (int[] row : image) {
                row[mid] = row[mid] ^ 1;
            }
        }
        return image;
    }
}
