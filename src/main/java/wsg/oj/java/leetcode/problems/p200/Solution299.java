package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 299. Bulls and Cows (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/bulls-and-cows/">Bulls and Cows</a>
 * @since 2021-07-13
 */
public class Solution299 implements Solution {

    /**
     * @complexity S=O(10)
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] inSecret = new int[10];
        int[] inGuess = new int[10];
        for (int i = 0, len = secret.length(); i < len; i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else {
                inSecret[c1 - '0']++;
                inGuess[c2 - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(inSecret[i], inGuess[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
