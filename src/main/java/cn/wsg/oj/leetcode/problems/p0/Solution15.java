package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum (Medium)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution16
 * @see Solution18
 * @see Solution259
 * @see <a href="https://leetcode-cn.com/problems/3sum/">3Sum</a>
 */
public class Solution15 implements Solution {

    /**
     * Sorts the array first, chooses a and then finds b&c using binary searching. Use pruning if
     * necessary.
     *
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_CONSTANT
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int av = nums[0] - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int ai = 0, aLen = n - 2; ai < aLen; ai++) {
            if (av == nums[ai]) {
                continue;
            }
            // if always larger than the target
            if (nums[ai] + nums[ai + 1] + nums[ai + 2] > 0) {
                continue;
            }
            // if always smaller than the target
            if (nums[ai] + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }
            av = nums[ai];
            int bi = ai + 1, ci = n - 1;
            while (bi < ci) {
                int sum = av + nums[bi] + nums[ci];
                if (sum < 0) {
                    bi++;
                } else if (sum > 0) {
                    ci--;
                } else {
                    int bv = nums[bi], cv = nums[ci];
                    res.add(Arrays.asList(av, bv, cv));
                    // find different ones
                    while (bi < ci && nums[bi] == bv) {
                        bi++;
                    }
                    while (bi < ci && nums[ci] == cv) {
                        ci--;
                    }
                }
            }
        }
        return res;
    }
}
