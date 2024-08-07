package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/">3106. Lexicographically Smallest String After Operations With Constraint</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2734
 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3106 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String getSmallestString(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n && k > 0; i++) {
            char ch = chars[i];
            int dist = Math.min(ch - 'a', 'z' - ch + 1);
            if (k >= dist) { // change to 'a'
                chars[i] = 'a';
                k -= dist;
            } else {
                chars[i] = (char) (chars[i] - k);
                k = 0;
            }
        }
        return new String(chars);
    }
}