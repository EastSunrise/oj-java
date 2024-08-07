package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/">2696. Minimum String Length After Removing Substrings</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2696 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minLength(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (len > 0 && (ch == 'B' && stack[len - 1] == 'A' || ch == 'D' && stack[len - 1] == 'C')) {
                len--;
            } else {
                stack[len++] = ch;
            }
        }
        return len;
    }
}