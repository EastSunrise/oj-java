package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution454;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum (Medium)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution15
 * @see Solution454
 * @see <a href="https://leetcode-cn.com/problems/4sum/">4Sum</a>
 */
public class Solution18 implements Solution {

    /**
     * It's similar to {@link Solution15}. Sort the array first, choose a&b and then find c&d using
     * binary searching. Use pruning if necessary.
     *
     * @see Complexity#TIME_NNN
     * @see Complexity#SPACE_CONSTANT
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int av = nums[0] - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int ai = 0, aLen = n - 3; ai < aLen; ai++) {
            if (av == nums[ai]) {
                continue;
            }
            // if always larger than the target
            if (nums[ai] + nums[ai + 1] + nums[ai + 2] + nums[ai + 3] > target) {
                continue;
            }
            // if always smaller than the target
            if (nums[ai] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            av = nums[ai];
            int bcd = target - av;
            int bv = av - 1;
            for (int bi = ai + 1, bLen = n - 2; bi < bLen; bi++) {
                if (bv == nums[bi]) {
                    continue;
                }
                // if always larger than the target
                if (nums[ai] + nums[bi] + nums[bi + 1] + nums[bi + 2] > target) {
                    continue;
                }
                // if always smaller than the target
                if (nums[ai] + nums[bi] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                bv = nums[bi];
                int cd = bcd - bv;
                int ci = bi + 1, di = n - 1;
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
                        while (ci < di && nums[ci] == cv) {
                            ci++;
                        }
                        while (ci < di && nums[di] == dv) {
                            di--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
