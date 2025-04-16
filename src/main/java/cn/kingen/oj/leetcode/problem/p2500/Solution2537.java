package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-good-subarrays/">2537. Count the Number of Good Subarrays</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1759
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2461

 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.SLIDING_WINDOW},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-16"
)
public class Solution2537 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0, total = 0;
        for (int i = 0, j = 0; i < n; i++) {
            total += freq.merge(nums[i], 1, Integer::sum) - 1;
            while (total >= k) { // until nums[j,i] is not a good subarray
                total -= freq.merge(nums[j++], -1, Integer::sum);
            }
            ans += j;
        }
        return ans;
    }
}