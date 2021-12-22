package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 1512. Number of Good Pairs (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 */
public class Solution1512 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int total = 0;
        for (int count : counts.values()) {
            total += count * (count - 1) / 2;
        }
        return total;
    }
}
