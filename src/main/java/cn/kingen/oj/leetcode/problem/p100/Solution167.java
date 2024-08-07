package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution1
 * @see cn.kingen.oj.leetcode.problem.p600.Solution653
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1099
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution167 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}