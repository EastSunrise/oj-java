package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/shifting-letters/">848. Shifting Letters</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1844
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2381
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2734
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution848 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            chars[i] = (char) ((chars[i] - 'a' + sum) % 26 + 'a');
        }
        return new String(chars);
    }
}