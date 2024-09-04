package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/backspace-string-compare/">844. Backspace String Compare</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1598
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2390
 */
@Question(
        tags = {Tag.STACK, Tag.TWO_POINTERS, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution844 {

    @Complexity(time = "O(m+n)", space = "O(1)")
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int hs = 0, ht = 0; // count of right '#'s in s and t respectively
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == '#') {
                hs++;
                i--;
            } else if (hs > 0) { // s[i] will be deleted
                hs--;
                i--;
            } else if (t.charAt(j) == '#') {
                ht++;
                j--;
            } else if (ht > 0) { // t[j] will be deleted
                ht--;
                j--;
            } else if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }
        if (i < 0) {
            i = j;
            s = t;
            hs = ht;
        }
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                hs++;
            } else if (hs > 0) {
                hs--;
            } else {
                return false;
            }
            i--;
        }
        return true;
    }
}