package cn.wsg.oj.leetcode.problems.p1600;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1694. Reformat Phone Number (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reformat-phone-number/">Reformat Phone Number</a>
 */
public class Solution1694 implements Solution {

    public String reformatNumber(String number) {
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        for (char ch : number.toCharArray()) {
            if (isDigit(ch)) {
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
