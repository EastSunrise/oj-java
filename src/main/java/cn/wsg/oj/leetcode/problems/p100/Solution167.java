package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution1;
import cn.wsg.oj.leetcode.problems.p600.Solution653;

/**
 * 167. Two Sum II - Input array is sorted (Easy)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution653
 * @see Solution1099
 * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II -
 * Input array is sorted</a>
 */
public class Solution167 implements Solution {

    /**
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
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
