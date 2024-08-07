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
        int n = s.length();
        int length = n * 2 + 1;
        char[] arr = new char[length];
        for (int i = 0; i < n; i++) {
            arr[2 * i] = '#';
            arr[2 * i + 1] = s.charAt(i);
        }
        arr[length - 1] = '#';
        // the radius of the lps that centres around arr[i]
        int[] radii = new int[length];
        // rmlps: the rightmost of all calculated lps
        // rm: the rightmost index of rmlps, rmc: the center index of rmlps
        int rm = -1, rmc = -1;
        for (int i = 1; i < length; i++) {
            int left = i - 1, right = i + 1;
            if (i < rm) {
                // If arr[i] is within rmlps, find the symmetry point arr[j] against arr[i] in rmlps.
                int j = rmc * 2 - i;
                // If the lps around arr[j] is totally within rmlps, the lps around arr[i] is
                // totally within rmlp too. So radii[i] = radii[j].
                if (radii[j] < rm - i) {
                    radii[i] = radii[j];
                    continue;
                }
                // If beyond, the part arr[2i-rm, rm] is palindrome by symmetry. So the part is
                // unnecessary to be calculated repeatedly.
                left = 2 * i - rm - 1;
                right = rm + 1;
            }
            // Then calculate the part beyond rmlps and update rmlps
            while (left >= 0 && right < length && arr[left] == arr[right]) {
                left--;
                right++;
            }
            radii[i] = right - i - 1;
            if (right > rm) {
                rm = right - 1;
                rmc = i;
            }
        }
        int max = 0, idx = 0;
        for (int i = 0; i < length; i++) {
            if (radii[i] > max) {
                max = radii[i];
                idx = i;
            }
        }
        StringBuilder builder = new StringBuilder(max);
        for (int i = idx - max + 1, j = idx + max; i < j; i += 2) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}