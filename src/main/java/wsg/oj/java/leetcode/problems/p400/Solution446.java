package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 446. Arithmetic Slices II - Subsequence (HARD)
 *
 * @author Kingen
 * @see Solution413
 * @see <a href="https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/">Arithmetic
 * Slices II - Subsequence</a>
 * @since 2021-07-27
 */
public class Solution446 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_NN
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
