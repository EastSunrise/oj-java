package cn.kingen.oj.leetcode.problem.ch01;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Map;

import static cn.kingen.oj.leetcode.util.StringUtils.statFrequency;

/**
 * <a href="https://leetcode.cn/problems/check-permutation-lcci/">面试题 01.02. Check Permutation LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Interview02 {

    @Complexity(time = "O(m+n+C)", space = "O(L)", note = "C is the number of distinct characters")
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> freq1 = statFrequency(s1);
        Map<Character, Integer> freq2 = statFrequency(s2);
        if (freq1.size() != freq2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : freq1.entrySet()) {
            if (!entry.getValue().equals(freq2.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }
}