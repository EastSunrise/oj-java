package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/longest-harmonious-subsequence/">Longest
 * Harmonious Subsequence</a>
 */
public class Solution594 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>(16);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int count = counts.getOrDefault(entry.getKey() + 1, 0);
            res = Math.max(res, count + entry.getValue());
        }
        return res;
    }
}
