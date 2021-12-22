package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 446. Arithmetic Slices II - Subsequence (HARD)
 *
 * @author Kingen
 * @see Solution413
 * @see <a href="https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/">Arithmetic
 * Slices II - Subsequence</a>
 */
public class Solution446 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_NN
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        List<Map<Long, Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long dif = (long) nums[j] - nums[i];
                int count = dp.get(j).getOrDefault(dif, 0);
                dp.get(i).put(dif, dp.get(i).getOrDefault(dif, 0) + count + 1);
                total += count;
            }
        }
        return total;
    }
}
