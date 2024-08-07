package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/">2575. Find the Divisibility Array of a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution974
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1590
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2575 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long reminder = 0;
        for (int i = 0; i < n; i++) {
            reminder = (reminder * 10 + (word.charAt(i) - '0')) % m;
            ans[i] = reminder == 0 ? 1 : 0;
        }
        return ans;
    }
}