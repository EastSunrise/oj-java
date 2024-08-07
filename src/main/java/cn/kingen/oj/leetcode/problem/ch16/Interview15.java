package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/master-mind-lcci/">面试题 16.15. Master Mind LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Interview15 {

    @Complexity(time = "O(n+C)", space = "O(C)", note = "C is the number of distinct characters")
    public int[] masterMind(String solution, String guess) {
        int n = solution.length();
        Map<Character, Integer> stat1 = new HashMap<>(), stat2 = new HashMap<>();
        int hit = 0;
        for (int i = 0; i < n; i++) {
            char ch1 = solution.charAt(i), ch2 = guess.charAt(i);
            if (ch1 == ch2) {
                hit++;
            } else {
                stat1.merge(ch1, 1, Integer::sum);
                stat2.merge(ch2, 1, Integer::sum);
            }
        }
        int pseudo = 0;
        for (Map.Entry<Character, Integer> entry : stat2.entrySet()) {
            pseudo += Math.min(entry.getValue(), stat1.getOrDefault(entry.getKey(), 0));
        }
        return new int[]{hit, pseudo};
    }
}