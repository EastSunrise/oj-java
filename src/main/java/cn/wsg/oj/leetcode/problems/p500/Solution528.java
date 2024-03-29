package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution398;
import cn.wsg.oj.leetcode.problems.p400.Solution497;
import java.util.Arrays;
import java.util.Random;

/**
 * 528. Random Pick with Weight (MEDIUM)
 *
 * @author Kingen
 * @see Solution398
 * @see Solution710
 * @see Solution497
 * @see <a href="https://leetcode-cn.com/problems/random-pick-with-weight/">Random Pick with
 * Weight</a>
 */
public class Solution528 implements Solution {

    static class Solution {

        private final int total;
        private final int[] prefixSums;
        private final Random random = new Random();

        public Solution(int[] w) {
            prefixSums = w;
            for (int i = 1; i < prefixSums.length; i++) {
                prefixSums[i] = prefixSums[i - 1] + prefixSums[i];
            }
            total = prefixSums[prefixSums.length - 1];
        }

        public int pickIndex() {
            int rand = random.nextInt(total);
            int i = Arrays.binarySearch(prefixSums, rand);
            return Math.abs(i + 1);
        }
    }
}
