package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution214
 * @see cn.kingen.oj.leetcode.problem.p200.Solution266
 * @see cn.kingen.oj.leetcode.problem.p300.Solution336
 * @see cn.kingen.oj.leetcode.problem.p500.Solution516
 * @see cn.kingen.oj.leetcode.problem.p600.Solution647
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution5 {

    /**
     * Manacher Algorithm.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public String longestPalindrome(String s) {
        int n = s.length(), len = n << 1 | 1;
        char[] arr = new char[len];
        for (int i = 0; i < n; i++) {
            arr[i << 1] = '#';
            arr[i << 1 | 1] = s.charAt(i);
        }
        arr[len - 1] = '#';

        int[] radii = new int[len];
        int left = -1, right = -1; // the bound of the rightmost calculated palindrome
        int mxi = 0;
        for (int i = 1; i < len; i++) {
            if (i <= right) { // use the mirror which has been calculated
                radii[i] = Math.min(radii[left + right - i], right - i);
            }

            int low = i - radii[i] - 1, high = i + radii[i] + 1;
            while (low >= 0 && high < len && arr[low] == arr[high]) { // expand
                low--;
                high++;
            }

            radii[i] = high - i - 1;
            if (high - 1 > right) {
                left = low + 1;
                right = high - 1;
            }

            if (radii[i] > radii[mxi]) {
                mxi = i;
            }
        }

        return s.substring((mxi - radii[mxi]) >> 1, (mxi + radii[mxi]) >> 1);
    }
}