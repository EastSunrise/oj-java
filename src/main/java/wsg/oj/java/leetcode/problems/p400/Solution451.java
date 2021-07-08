package wsg.oj.java.leetcode.problems.p400;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 451. Sort Characters By Frequency (Medium)
 *
 * @author Kingen
 * @see Solution347
 * @see Solution387
 * @see Solution1636
 * @see <a href="https://leetcode-cn.com/problems/sort-characters-by-frequency/">Sort Characters By
 * Frequency</a>
 * @since 2021-07-08
 */
class Solution451 extends Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>(64);
        for (char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        return frequency.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue()))
            .collect(Collectors.joining());
    }
}
