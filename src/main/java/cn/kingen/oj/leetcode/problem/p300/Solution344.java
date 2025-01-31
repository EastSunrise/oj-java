package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">344. Reverse String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution345
 * @see cn.kingen.oj.leetcode.problem.p500.Solution541
 */
@Question(
    tags = {Tag.TWO_POINTERS, Tag.STRING},
    difficulty = Difficulty.EASY
)
public class Solution344 {

    @Complexity(time = "O(n)", space = "O(1)")
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1; i < j; ) {
            tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}