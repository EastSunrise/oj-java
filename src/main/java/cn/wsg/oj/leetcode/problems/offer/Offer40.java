package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.p200.Solution215;
import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数  LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/">最小的k个数  LCOF</a>
 */
public class Offer40 extends Solution215 {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        findKthSmallest(arr, k, 0, arr.length);
        return Arrays.copyOf(arr, k);
    }
}
