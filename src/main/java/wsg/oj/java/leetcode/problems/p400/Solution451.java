package wsg.oj.java.leetcode.problems.p400;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution347;
import wsg.oj.java.leetcode.problems.p300.Solution387;

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
public class Solution451 implements Solution {

    /**
     * @complexity T=O(n+s), s=the size of the character set
     * @complexity S=O(s)
     */
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>(64);
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue()))
            .collect(Collectors.joining());
    }
}
