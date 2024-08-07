package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-closest-lcci/">面试题 17.11. Find Closest LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Interview11 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int findClosest(String[] words, String word1, String word2) {
        int k1 = -1, k2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                k1 = i;
            } else if (words[i].equals(word2)) {
                k2 = i;
            }
            if (k1 != -1 && k2 != -1) {
                min = Math.min(min, Math.abs(k1 - k2));
            }
        }
        return min;
    }
}