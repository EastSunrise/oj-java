package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/replace-all-digits-with-characters/">1844. Replace All Digits with Characters</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution848
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution1844 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String replaceDigits(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i += 2) {
            chars[i] = (char) (chars[i - 1] + chars[i] - '0');
        }
        return new String(chars);
    }
}