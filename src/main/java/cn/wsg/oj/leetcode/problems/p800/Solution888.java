package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 888. Fair Candy Swap (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/fair-candy-swap/">Fair Candy Swap</a>
 */
public class Solution888 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_N
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
