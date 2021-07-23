package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution495;

/**
 * 605. Can Place Flowers (EASY)
 *
 * @author Kingen
 * @see Solution495
 * @see Solution735
 * @see <a href="https://leetcode-cn.com/problems/can-place-flowers/">Can Place Flowers</a>
 * @since 2021-07-23
 */
public class Solution605 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length - 1;
        if (len == 0) {
            return n <= (flowerbed[0] ^ 1);
        }
        int count = 0;
        // the first one
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count++;
        }
        for (int i = 1; i < len; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        // the last one
        if (flowerbed[len] == 0 && flowerbed[len - 1] == 0) {
            count++;
        }
        return n <= count;
    }
}
