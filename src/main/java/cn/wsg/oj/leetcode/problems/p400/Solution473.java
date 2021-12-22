package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 473. Matchsticks to Square (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/matchsticks-to-square/">Matchsticks to Square</a>
 */
public class Solution473 implements Solution {

    /**
     * Divides the array into four parts whose sums are equal to each other.
     *
     * @complexity T=O(4^n)
     * @complexity S=O(n)
     * @see #BACKTRACKING
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return isSquare(new int[4], matchsticks, sum / 4, matchsticks.length - 1);
    }

    private boolean isSquare(int[] sides, int[] sticks, int target, int idx) {
        if (idx < 0) {
            return true;
        }
        int stick = sticks[idx--];
        for (int j = 0; j < 4; j++) {
            if (sides[j] + stick > target) {
                // oversize
                continue;
            }
            if (j > 0 && sides[j] == sides[j - 1]) {
                // the previous side with the same length has already failed
                // it's redundant to try again
                continue;
            }
            sides[j] += stick;
            if (isSquare(sides, sticks, target, idx)) {
                return true;
            }
            sides[j] -= stick;
        }
        return false;
    }
}
