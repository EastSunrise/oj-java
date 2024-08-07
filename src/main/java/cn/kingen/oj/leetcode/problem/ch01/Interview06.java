package cn.kingen.oj.leetcode.problem.ch01;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/compress-string-lcci/">面试题 01.06. Compress String LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Interview06 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String compressString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int n = s.length();
        char cur = s.charAt(0);
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == cur) {
                count++;
            } else {
                builder.append(cur).append(count);
                cur = ch;
                count = 1;
            }
        }
        builder.append(cur).append(count);
        return builder.length() < n ? builder.toString() : s;
    }
}