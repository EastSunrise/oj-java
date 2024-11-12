package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/">3216. Lexicographically Smallest String After a Swap</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1625
 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution3216 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String getSmallestString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i++) {
            char a = chars[i - 1], b = chars[i];
            if (a > b && (a & 1) == (b & 1)) {
                chars[i - 1] = b;
                chars[i] = a;
                return new String(chars);
            }
        }
        return s;
    }
}