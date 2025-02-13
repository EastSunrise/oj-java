package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/reverse-string-ii/">541. Reverse String II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution344
 * @see cn.kingen.oj.leetcode.problem.p500.Solution557
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2810
 */
@Question(
    tags = {Tag.TWO_POINTERS, Tag.STRING},
    difficulty = Difficulty.EASY,
        date = "2025-01-31"
)
public class Solution541 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int low = i, high = Math.min(i + k, n) - 1;
            while (low < high) {
                char tmp = chars[low];
                chars[low++] = chars[high];
                chars[high--] = tmp;
            }
        }
        return new String(chars);
    }
}