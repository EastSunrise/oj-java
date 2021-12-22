package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution1;
import cn.wsg.oj.leetcode.problems.p700.Solution713;
import cn.wsg.oj.leetcode.problems.p700.Solution724;
import cn.wsg.oj.leetcode.problems.p900.Solution974;
import java.util.HashMap;
import java.util.Map;

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
 */
public class Solution560 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
