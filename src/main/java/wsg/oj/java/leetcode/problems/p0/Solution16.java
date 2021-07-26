package wsg.oj.java.leetcode.problems.p0;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 16. 3Sum Closest (Medium)
 *
 * @author Kingen
 * @see Solution15
 * @see Solution259
 * @see <a href="https://leetcode-cn.com/problems/3sum-closest/">3Sum Closest</a>
 * @since 2021-07-10
 */
public class Solution16 implements Solution {

    /**
     * It's similar to {@link Solution15}. Sort the array first, choose a and then find b&c using
     * binary searching. Use pruning if necessary.
     *
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int av = nums[0] - 1;
        int minDif = Integer.MAX_VALUE;
        boolean larger = false;
        for (int ai = 0, aLen = len - 2; ai < aLen; ai++) {
            if (av == nums[ai]) {
                continue;
            }
            av = nums[ai];
            int bc = target - av;
            // find the closest
            int bi = ai + 1, ci = len - 1;
            while (bi < ci) {
                int sum = nums[bi] + nums[ci];
                if (sum < bc) {
                    int dif = bc - sum;
                    if (dif < minDif) {
                        minDif = dif;
                        larger = false;
                    }
                    bi++;
                } else if (sum > bc) {
                    int dif = sum - bc;
                    if (dif < minDif) {
                        minDif = dif;
                        larger = true;
                    }
                    ci--;
                } else {
                    return target;
                }
            }
        }
        return larger ? target + minDif : target - minDif;
    }
}
