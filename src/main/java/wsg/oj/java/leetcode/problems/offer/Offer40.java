package wsg.oj.java.leetcode.problems.offer;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.p200.Solution215;

/**
 * 剑指 Offer 40. 最小的k个数  LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/">最小的k个数  LCOF</a>
 * @since 2021-07-28
 */
public class Offer40 extends Solution215 {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        findKthSmallest(arr, k, 0, arr.length);
        return Arrays.copyOf(arr, k);
    }
}
