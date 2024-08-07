package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/reformat-phone-number/">1694. Reformat Phone Number</a>
 *
 * @author Kingen
 */
@Question(tags = {Tag.STRING}, difficulty = Difficulty.EASY)
public class Solution1694 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String reformatNumber(String number) {
        int cnt = 0, n = number.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                cnt++;
                if (cnt > 3) {
                    builder.append('-');
                    cnt -= 3;
                }
                builder.append(ch);
            }
        }
        if (cnt == 1) {
            builder.setCharAt(builder.length() - 2, builder.charAt(builder.length() - 3));
            builder.setCharAt(builder.length() - 3, '-');
        }
        return builder.toString();
    }
}