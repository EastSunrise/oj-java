package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/sort-characters-by-frequency/">451. Sort Characters By Frequency</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution347
 * @see cn.kingen.oj.leetcode.problem.p300.Solution387
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.BUCKET_SORT, Tag.COUNTING, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution451 {

    @Complexity(time = "O(n+C)", space = "O(n)", note = "n is the length of string, C is the number of distinct characters")
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>(64);
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue()))
                .collect(Collectors.joining());
    }
}