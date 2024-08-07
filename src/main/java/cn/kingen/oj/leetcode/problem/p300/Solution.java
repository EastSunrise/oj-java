package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Random;

import static cn.kingen.oj.leetcode.util.ArrayUtils.swap;

/**
 * <a href="https://leetcode.cn/problems/shuffle-an-array/">384. Shuffle an Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.RANDOMIZED},
        difficulty = Difficulty.MEDIUM
)
public class Solution {

    private final int[] nums;
    private final int[] shuffle;

    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffle = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    @Complexity(time = "O(1)", space = "O(1)")
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     *
     * @see <a href="https://eastsunrise.github.io/wiki-kingen/en/cs/algo/others/knuth-shuffle-algorithm.html">Knuth Shuffle Algorithm</a>
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = shuffle.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(shuffle, j, i);
        }
        return shuffle;
    }
}