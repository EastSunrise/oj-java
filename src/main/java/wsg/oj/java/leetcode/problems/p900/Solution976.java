package wsg.oj.java.leetcode.problems.p900;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p800.Solution812;

/**
 * 976. Largest Perimeter Triangle (EASY)
 *
 * @author Kingen
 * @see Solution812
 * @see <a href="https://leetcode-cn.com/problems/largest-perimeter-triangle/">Largest Perimeter
 * Triangle</a>
 * @since 2021-07-27
 */
public class Solution976 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i >= 2) {
            int sum = nums[i - 2] + nums[i - 1];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
            i--;
        }
        return 0;
    }
}
