package wsg.oj.java.leetcode.problems.p500;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 532. K-diff Pairs in an Array (MEDIUM)
 *
 * @author Kingen
 * @see Solution530
 * @see <a href="https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/">K-diff Pairs in an
 * Array</a>
 * @since 2021-07-20
 */
public class Solution532 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int pairs = 0;
        if (k == 0) {
            for (int count : counts.values()) {
                if (count > 1) {
                    pairs++;
                }
            }
        } else {
            for (int num : counts.keySet()) {
                if (counts.containsKey(num + k)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
