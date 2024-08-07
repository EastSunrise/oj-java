package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/repeated-dna-sequences/">187. Repeated DNA Sequences</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW, Tag.HASH_FUNCTION, Tag.ROLLING_HASH},
        difficulty = Difficulty.MEDIUM
)
public class Solution187 {

    /**
     * Uses a 20-bits to represent a 10-letter-long sequence.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n <= 10) {
            return new ArrayList<>();
        }

        int hash = 0;
        // the hash of the first 9 letters
        for (int i = 0; i < 9; i++) {
            hash = (hash << 2) + charToQuaternary(s.charAt(i));
        }
        Map<Integer, Integer> counts = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 9; i < n; i++) {
            hash = (hash << 2) + charToQuaternary(s.charAt(i));
            int count = counts.getOrDefault(hash, 0);
            if (count == 1) { // find the repeated sequence
                ans.add(s.substring(i - 9, i + 1));
            }
            counts.put(hash, count + 1);
            hash = hash & 0x3ffff; // remove the first letter
        }
        return ans;
    }

    private int charToQuaternary(char ch) {
        return switch (ch) {
            case 'A' -> 0;
            case 'C' -> 1;
            case 'G' -> 2;
            default -> 3;
        };
    }
}