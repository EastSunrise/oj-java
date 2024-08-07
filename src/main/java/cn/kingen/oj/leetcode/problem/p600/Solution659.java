package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/split-array-into-consecutive-subsequences/">659. Split Array into Consecutive Subsequences</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution347
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution659 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        Map<Integer, Integer> sequences = new HashMap<>();
        for (int num : nums) {
            int cnt = freq.get(num);
            if (cnt == 0) {
                continue;
            }
            freq.put(num, cnt - 1);
            int ends = sequences.getOrDefault(num - 1, 0);
            if (ends > 0) { // append this number after an existing sequence
                sequences.put(num - 1, ends - 1);
                sequences.merge(num, 1, Integer::sum);
                continue;
            }

            // use this number to start a new sequence
            int next = freq.getOrDefault(num + 1, 0);
            if (next == 0) {
                return false;
            }
            freq.put(num + 1, next - 1);
            next = freq.getOrDefault(num + 2, 0);
            if (next == 0) {
                return false;
            }
            freq.put(num + 2, next - 1);
            sequences.merge(num + 2, 1, Integer::sum);
        }
        return true;
    }
}