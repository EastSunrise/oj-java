package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p800.Solution812;
import java.util.Arrays;

/**
 * 976. Largest Perimeter Triangle (EASY)
 *
 * @author Kingen
 * @see Solution812
 * @see <a href="https://leetcode-cn.com/problems/largest-perimeter-triangle/">Largest Perimeter
 * Triangle</a>
 */
public class Solution976 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
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
