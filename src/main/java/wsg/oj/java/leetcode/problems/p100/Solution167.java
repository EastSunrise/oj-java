package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution1;
import wsg.oj.java.leetcode.problems.p600.Solution653;

/**
 * 167. Two Sum II - Input array is sorted (Easy)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution653
 * @see Solution1099
 * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II -
 * Input array is sorted</a>
 * @since 2021-07-12
 */
public class Solution167 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        throw new IllegalArgumentException("Not found");
    }
}
