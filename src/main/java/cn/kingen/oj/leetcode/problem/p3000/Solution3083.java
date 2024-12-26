package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/">3083. Existence of a Substring in a String and Its Reverse</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution3083 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is 26")
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        int[] next = new int[26];
        for (int i = 1; i < n; i++) {
            int cur = s.charAt(i) - 'a', prev = s.charAt(i - 1) - 'a';
            next[prev] |= 1 << cur;
            if ((next[cur] & (1 << prev)) != 0) {
                return true;
            }
        }
        return false;
    }
}