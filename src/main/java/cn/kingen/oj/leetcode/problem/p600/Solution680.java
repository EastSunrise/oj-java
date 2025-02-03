package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/">680. Valid Palindrome II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution125
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1216
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2330
 */
@Question(
        tags = {Tag.GREEDY, Tag.TWO_POINTERS, Tag.STRING},
    difficulty = Difficulty.EASY,
    daily = "2025-02-03"
)
public class Solution680 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        // check whether s[left+1,right] is a palindrome
        int i = left + 1, j = right;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) {
            return true;
        }
        i = left;
        j = right - 1;
        // check whether s[left,right-1] is a palindrome
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}