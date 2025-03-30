package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/adding-spaces-to-a-string/">2109. Adding Spaces to a String</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.STRING, Tag.SIMULATION},
    difficulty = Difficulty.MEDIUM,
    date = "2025-03-30"
)
public class Solution2109 {

    @Complexity(time = "O(n+m)", space = "O(n+m)")
    public String addSpaces(String s, int[] spaces) {
        int n = s.length(), m = spaces.length;
        char[] chars = new char[n + m];
        for (int i = 0, j = 0; i < n; i++) {
            if (j < m && i == spaces[j]) {
                chars[i + j++] = ' ';
            }
            chars[i + j] = s.charAt(i);
        }
        return new String(chars);
    }
}