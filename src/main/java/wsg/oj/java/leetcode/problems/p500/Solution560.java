package wsg.oj.java.leetcode.problems.p500;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution1;
import wsg.oj.java.leetcode.problems.p700.Solution713;
import wsg.oj.java.leetcode.problems.p700.Solution724;
import wsg.oj.java.leetcode.problems.p900.Solution974;

/**
 * 560. Subarray Sum Equals K (MEDIUM)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution523
 * @see Solution713
 * @see Solution724
 * @see Solution974
 * @see Solution1658
 * @see <a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">Subarray Sum Equals K</a>
 * @since 2021-07-20
 */
public class Solution560 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixSums.getOrDefault(sum - k, 0);
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
