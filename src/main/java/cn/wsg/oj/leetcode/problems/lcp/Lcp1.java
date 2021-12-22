package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 1. Guess Numbers (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/guess-numbers/">Guess Numbers</a>
 */
public class Lcp1 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
