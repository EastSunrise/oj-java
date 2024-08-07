package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/buddy-strings/">859. Buddy Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1657
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1790
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2531
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution859 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) {
            return false;
        }
        int i = 0;
        while (i < n && s.charAt(i) == goal.charAt(i)) { // find the first different char
            i++;
        }

        if (i == n) { // no different char
            int mask = 0;
            for (int k = 0; k < n; k++) {
                int b = 1 << (s.charAt(k) - 'a');
                if ((mask & b) != 0) {
                    return true;
                }
                mask |= b;
            }
            return false;
        }

        int j = i + 1;
        while (j < n && s.charAt(j) == goal.charAt(j)) { // find the second different char
            j++;
        }
        if (j == n) { // only one different char
            return false;
        }

        int k = j + 1;
        while (k < n && s.charAt(k) == goal.charAt(k)) { // find the third different char
            k++;
        }
        if (k == n) { // exactly two different chars
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }
        return false;
    }
}