package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/">560. Subarray Sum Equals K</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution1
 * @see cn.kingen.oj.leetcode.problem.p500.Solution523
 * @see cn.kingen.oj.leetcode.problem.p700.Solution713
 * @see cn.kingen.oj.leetcode.problem.p700.Solution724
 * @see cn.kingen.oj.leetcode.problem.p900.Solution974
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution560 {

    @Complexity(time = "O(n)", space = "O(n)")
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