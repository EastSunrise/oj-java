package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/words-frequency-lcci/">面试题 16.02. Words Frequency LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DESIGN, Tag.TRIE, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class WordsFrequency {

    private final Map<String, Integer> counts;

    @Complexity(time = "O(n)", space = "O(n)")
    WordsFrequency(String[] book) {
        this.counts = new HashMap<>();
        for (String word : book) {
            counts.merge(word, 1, Integer::sum);
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    int get(String word) {
        return counts.getOrDefault(word, 0);
    }
}