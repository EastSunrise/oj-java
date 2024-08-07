package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/bulls-and-cows/">299. Bulls and Cows</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2531
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution299 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is the number of distinct characters")
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] secretCount = new int[10], guessCount = new int[10];
        for (int i = 0, len = secret.length(); i < len; i++) {
            char ch1 = secret.charAt(i), ch2 = guess.charAt(i);
            if (ch1 == ch2) {
                bull++;
            } else {
                secretCount[ch1 - '0']++;
                guessCount[ch2 - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(secretCount[i], guessCount[i]);
        }
        return bull + "A" + cow + "B";
    }
}