package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution278;
import wsg.oj.java.leetcode.problems.p600.Solution658;

/**
 * 374. Guess Number Higher or Lower (Easy)
 *
 * @author Kingen
 * @see Solution278
 * @see Solution375
 * @see Solution658
 * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower/">Guess Number Higher
 * or Lower</a>
 * @since 2021-07-13
 */
public class Solution374 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int res = guess(mid);
            if (res < 0) {
                high = mid - 1;
            } else if (res > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number 1 if num is higher than the guess number
     * otherwise return 0
     */
    private int guess(int num) {
        return Integer.compare(num, 6);
    }
}
