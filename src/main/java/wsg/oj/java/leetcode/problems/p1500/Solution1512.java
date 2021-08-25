package wsg.oj.java.leetcode.problems.p1500;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1512. Number of Good Pairs (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 * @since 2021-07-27
 */
public class Solution1512 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
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
