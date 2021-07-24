package wsg.oj.java.leetcode.problems.p600;

import java.util.Arrays;
import java.util.Comparator;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution300;
import wsg.oj.java.leetcode.problems.p400.Solution491;

/**
 * 646. Maximum Length of Pair Chain (MEDIUM)
 *
 * @author Kingen
 * @see Solution300
 * @see Solution491
 * @see <a href="https://leetcode-cn.com/problems/maximum-length-of-pair-chain/">Maximum Length of
 * Pair Chain</a>
 * @since 2021-07-23
 */
public class Solution646 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int count = 1, right = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > right) {
                count++;
                right = pairs[i][1];
            }
        }
        return count;
    }
}
