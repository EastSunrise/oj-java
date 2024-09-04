package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/guess-the-word/">843. Guess the Word</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.STRING, Tag.GAME_THEORY, Tag.INTERACTIVE},
        difficulty = Difficulty.HARD
)
public class Solution843 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public void findSecretWord(String[] words, Master master) {
        Set<String> candidates = new HashSet<>(Arrays.asList(words));
        while (!candidates.isEmpty()) {
            String word = candidates.iterator().next();
            int cnt = master.guess(word);
            if (cnt == 6) {
                return;
            }
            candidates.removeIf(candidate -> match(word, candidate) != cnt);
        }
    }

    private int match(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}