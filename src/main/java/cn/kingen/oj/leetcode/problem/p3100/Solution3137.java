package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/">3137. Minimum Number of Operations to Make Word K-Periodic</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1668

 */
@Question(
    tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
    difficulty = Difficulty.MEDIUM
)
public class Solution3137 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String sub = word.substring(i, i + k);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
        }
        int max = 0;
        for (int value : freq.values()) {
            max = Math.max(max, value);
        }
        return n / k - max;
    }
}