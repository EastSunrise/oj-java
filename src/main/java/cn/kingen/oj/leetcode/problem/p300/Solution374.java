package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/guess-number-higher-or-lower/">374. Guess Number Higher or Lower</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution278
 * @see cn.kingen.oj.leetcode.problem.p300.Solution375
 * @see cn.kingen.oj.leetcode.problem.p600.Solution658
 */
@Question(
        tags = {Tag.BINARY_SEARCH, Tag.INTERACTIVE},
        difficulty = Difficulty.EASY
)
public class Solution374 {

    @Complexity(time = "O(log n)", space = "O(1)")
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int cmp = guess(mid);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
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
     * @param ignoredNum your guess
     * @return -1 if num is lower than the guess number 1 if num is higher than the guess number
     * otherwise return 0
     */
    int guess(int ignoredNum) {
        return 0;
    }
}