package wsg.oj.java.leetcode.problems.p800;

import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 888. Fair Candy Swap (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/fair-candy-swap/">Fair Candy Swap</a>
 * @since 2021-07-27
 */
public class Solution888 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum = 0;
        for (int a : aliceSizes) {
            sum += a;
        }
        for (int b : bobSizes) {
            sum -= b;
        }
        int dif = sum / 2;
        Set<Integer> bobs = new HashSet<>(bobSizes.length);
        for (int bobSize : bobSizes) {
            bobs.add(bobSize);
        }
        for (int aliceSize : aliceSizes) {
            int target = aliceSize - dif;
            if (target > 0 && bobs.contains(target)) {
                return new int[]{aliceSize, target};
            }
        }
        throw new IllegalArgumentException("Not found");
    }
}
