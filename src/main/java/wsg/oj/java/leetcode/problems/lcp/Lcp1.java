package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 1. Guess Numbers (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/guess-numbers/">Guess Numbers</a>
 * @since 2021-07-28
 */
public class Lcp1 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int game(int[] guess, int[] answer) {
        int n = guess.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (guess[i] == answer[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
