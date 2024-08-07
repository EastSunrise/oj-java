package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/">2734. Lexicographically Smallest String After Substring Operation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution848
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1625
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3106
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3081
 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2734 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String smallestString(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }
        if (i == n) {
            return s.substring(0, n - 1) + 'z';
        }

        char[] chars = s.toCharArray();
        while (i < n && chars[i] != 'a') {
            chars[i] = (char) (chars[i] - 1);
            i++;
        }
        return new String(chars);
    }
}