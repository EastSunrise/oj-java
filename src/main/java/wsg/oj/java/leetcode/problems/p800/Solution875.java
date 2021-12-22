package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 875. Koko Eating Bananas (MEDIUM)
 *
 * @author Kingen
 * @see Solution774
 * @see <a href="https://leetcode-cn.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
 * @since 2021-07-27
 */
public class Solution875 implements Solution {

    /**
     * @see #BINARY_SEARCH
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MAX_VALUE;
        for (int pile : piles) {
            if (pile > low && pile < high) {
                if (calculate(piles, pile) > h) {
                    low = pile;
                } else {
                    high = pile;
                }
            }
        }

        while (low <= high) {
            int k = (low + high) / 2;
            if (calculate(piles, k) > h) {
                low = k + 1;
            } else {
                high = k - 1;
            }
        }
        return low;
    }

    private int calculate(int[] piles, int k) {
        int time = 0;
        for (int pile : piles) {
            time += (pile - 1) / k + 1;
        }
        return time;
    }
}
