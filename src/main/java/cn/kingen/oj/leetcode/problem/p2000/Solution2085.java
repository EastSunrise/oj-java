package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-common-words-with-one-occurrence/">2085. Count Common Words With One Occurrence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution349
 * @see cn.kingen.oj.leetcode.problem.p800.Solution884
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2053
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Solution2085 {

    @Complexity(time = "O(m+n)", space = "O(m+n)")
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> counts1 = new HashMap<>(), counts2 = new HashMap<>();
        for (String word : words1) {
            counts1.put(word, counts1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            counts2.put(word, counts2.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : counts1.entrySet()) {
            if (entry.getValue() == 1 && counts2.getOrDefault(entry.getKey(), 0) == 1) {
                ans++;
            }
        }
        return ans;
    }
}