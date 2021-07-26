package wsg.oj.java.leetcode.problems.p600;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution347;

/**
 * 659. Split Array into Consecutive Subsequences (MEDIUM)
 *
 * @author Kingen
 * @see Solution347
 * @see Solution1296
 * @see <a href="https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/">Split
 * Array into Consecutive Subsequences</a>
 * @since 2021-07-23
 */
public class Solution659 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> sequences = new HashMap<>();
        for (int num : nums) {
            int count = counts.get(num);
            if (count == 0) {
                continue;
            }
            counts.put(num, count - 1);
            int ends = sequences.getOrDefault(num - 1, 0);
            if (ends > 0) {
                // append this number after a sequence
                sequences.put(num - 1, ends - 1);
                sequences.put(num, sequences.getOrDefault(num, 0) + 1);
                continue;
            }
            // no sequence to be followed
            int next = counts.getOrDefault(num + 1, 0);
            if (next == 0) {
                return false;
            }
            counts.put(num + 1, next - 1);
            next = counts.getOrDefault(num + 2, 0);
            if (next == 0) {
                return false;
            }
            counts.put(num + 2, next - 1);
            // add a sequence: num, num+1, num+2
            sequences.put(num + 2, sequences.getOrDefault(num + 2, 0) + 1);
        }
        return true;
    }
}
