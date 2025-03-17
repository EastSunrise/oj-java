package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/">1963. Minimum Number of Swaps to Make the String Balanced</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution301
 * @see cn.kingen.oj.leetcode.problem.p900.Solution921
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1249
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1541

 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-17"
)
public class Solution1963 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int left = 0, cnt = 0;
        for (int i = 0, j = s.length() - 1; i < j; i++) {
            if (chars[i] == '[') {
                left++;
            } else if (left > 0) {
                left--;
            } else {
                while (chars[j] != '[') {
                    j--;
                }
                // swap s[i] and s[j]
                cnt++;
                left++;
                j--;
            }
        }
        return cnt;
    }
}