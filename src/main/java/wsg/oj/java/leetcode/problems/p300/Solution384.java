package wsg.oj.java.leetcode.problems.p300;

import java.util.Arrays;
import java.util.Random;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 384. Shuffle an Array (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shuffle-an-array/">Shuffle an Array</a>
 * @since 2021-07-06
 */
public class Solution384 implements Solution {

    /**
     * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/algorithms/others/knuth-shuffle-algorithm.html">Knuth
     * Shuffle Algorithm</a>
     */
    private static class Solution {

        private final int[] nums;
        private final int[] shuffle;

        public Solution(int[] nums) {
            this.nums = nums;
            this.shuffle = Arrays.copyOf(nums, nums.length);
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            Random random = new Random();
            for (int i = shuffle.length - 1; i >= 0; i--) {
                int j = random.nextInt(i + 1);
                int tmp = shuffle[j];
                shuffle[j] = shuffle[i];
                shuffle[i] = tmp;
            }
            return shuffle;
        }
    }
}
