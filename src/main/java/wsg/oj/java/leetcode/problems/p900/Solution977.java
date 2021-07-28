package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution88;

/**
 * 977. Squares of a Sorted Array (EASY)
 *
 * @author Kingen
 * @see Solution88
 * @see Solution360
 * @see <a href="https://leetcode-cn.com/problems/squares-of-a-sorted-array/">Squares of a Sorted
 * Array</a>
 * @since 2021-07-27
 */
public class Solution977 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
        }
        int[] res = new int[n];
        int j = i - 1, k = 0;
        while (j >= 0 && i < n) {
            if (nums[i] < nums[j]) {
                res[k++] = nums[i] * nums[i++];
            } else {
                res[k++] = nums[j] * nums[j--];
            }
        }
        while (i < n) {
            res[k++] = nums[i] * nums[i++];
        }
        while (j >= 0) {
            res[k++] = nums[j] * nums[j--];
        }
        return res;
    }
}
