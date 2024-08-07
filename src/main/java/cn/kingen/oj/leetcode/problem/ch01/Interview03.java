package cn.kingen.oj.leetcode.problem.ch01;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/string-to-url-lcci/">面试题 01.03. String to URL LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Interview03 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String replaceSpaces(String s, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}