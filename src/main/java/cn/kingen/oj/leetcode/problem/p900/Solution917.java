package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/reverse-only-letters/">917. Reverse Only Letters</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2810
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution917 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (!Character.isLetter(chars[i])) {
                i++;
            } else if (!Character.isLetter(chars[j])) {
                j--;
            } else {
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
        }
        return new String(chars);
    }
}