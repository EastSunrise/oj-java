package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution121;
import wsg.oj.java.leetcode.problems.p100.Solution152;
import wsg.oj.java.leetcode.problems.p600.Solution697;

/**
 * 53. Maximum Subarray (Easy)
 *
 * @author Kingen
 * @see Solution121
 * @see Solution152
 * @see Solution697
 * @see Solution978
 * @see Solution1749
 * @see Solution1746
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">Maximum Subarray</a>
 * @since 2021-07-11
 */
public class Solution53 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxSubArray(int[] nums) {
        // the minimal prefix sum
        int min = 0, sum = 0, max = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}
