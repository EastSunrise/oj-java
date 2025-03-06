package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/">2588. Count the Number of Beautiful Subarrays</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1829
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2338

 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-06"
)
public class Solution2588 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        long ans = 0;
        int xor = 0, cnt;
        for (int num : nums) {
            xor ^= num;
            cnt = freq.getOrDefault(xor, 0);
            ans += cnt;
            freq.put(xor, cnt + 1);
        }
        return ans;
    }
}