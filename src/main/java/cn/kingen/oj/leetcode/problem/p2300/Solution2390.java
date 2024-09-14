package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/removing-stars-from-a-string/">2390. Removing Stars From a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution844
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1047
 */
@Question(
        tags = {Tag.STACK, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2390 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String removeStars(String s) {
        int n = s.length();
        char[] chars = new char[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                j--;
            } else {
                chars[j++] = ch;
            }
        }
        return new String(chars, 0, j);
    }
}