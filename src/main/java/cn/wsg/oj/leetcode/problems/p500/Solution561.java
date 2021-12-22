package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 561. Array Partition I (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/array-partition-i/">Array Partition I</a>
 */
public class Solution561 implements Solution {

    /**
     * Supposes that min[i] is the ith smallest number. If min[0] and min[1] are not in the same
     * pair, there exist pairs (min[0], x) and (min[1], y). Exchange x and min[1], then the sum will
     * be larger. So the maximized group is (min[0], min[1]), ..., (min[2n-2], min[2n-1]).
     *
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
