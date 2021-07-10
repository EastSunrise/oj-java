package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 18. 4Sum (Medium)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution15
 * @see Solution454
 * @see <a href="https://leetcode-cn.com/problems/4sum/">4Sum</a>
 * @since 2021-07-10
 */
public class Solution18 implements Solution {

    /**
     * It's similar to {@link Solution15}. Sort the array first, choose a&b and then find c&d using
     * binary searching. Use pruning if necessary.
     *
     * @see wsg.oj.java.Complexity#TIME_NNN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int av = nums[0] - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int ai = 0, aLen = len - 3; ai < aLen; ai++) {
            if (av == nums[ai]) {
                continue;
            }
            // if always larger than the target
            if (nums[ai] + nums[ai + 1] + nums[ai + 2] + nums[ai + 3] > target) {
                continue;
            }
            // if always smaller than the target
            if (nums[ai] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            av = nums[ai];
            int bcd = target - av;
            int bv = av - 1;
            for (int bi = ai + 1, bLen = len - 2; bi < bLen; bi++) {
                if (bv == nums[bi]) {
                    continue;
                }
                // if always larger than the target
                if (nums[ai] + nums[bi] + nums[bi + 1] + nums[bi + 2] > target) {
                    continue;
                }
                // if always smaller than the target
                if (nums[ai] + nums[bi] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                bv = nums[bi];
                int cd = bcd - bv;
                int ci = bi + 1, di = len - 1;
                while (ci < di) {
                    int sum = nums[ci] + nums[di];
                    if (sum > cd) {
                        di--;
                    } else if (sum < cd) {
                        ci++;
                    } else {
                        int cv = nums[ci], dv = nums[di];
                        res.add(Arrays.asList(av, bv, cv, dv));
                        // find different ones
                        do {
                            ci++;
                        } while (ci < di && nums[ci] == cv);
                        do {
                            di--;
                        } while (ci < di && nums[di] == dv);
                    }
                }
            }
        }
        return res;
    }
}
