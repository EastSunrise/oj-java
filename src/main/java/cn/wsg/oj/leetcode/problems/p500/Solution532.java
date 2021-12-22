package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 532. K-diff Pairs in an Array (MEDIUM)
 *
 * @author Kingen
 * @see Solution530
 * @see <a href="https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/">K-diff Pairs in an
 * Array</a>
 */
public class Solution532 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
