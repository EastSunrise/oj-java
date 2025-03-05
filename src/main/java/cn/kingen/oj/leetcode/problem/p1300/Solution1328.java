package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/break-a-palindrome/">1328. Break a Palindrome</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-05"
)
public class Solution1328 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length(), half = n / 2;
        if (n == 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < half; i++) {
            if (palindrome.charAt(i) != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[n - 1] = 'b';
        return new String(chars);
    }
}