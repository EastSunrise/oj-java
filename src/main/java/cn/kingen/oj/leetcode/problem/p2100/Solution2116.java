package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/check-if-a-parentheses-string-can-be-valid/">2116. Check if a Parentheses String Can Be Valid</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution20
 * @see cn.kingen.oj.leetcode.problem.p0.Solution22
 * @see cn.kingen.oj.leetcode.problem.p600.Solution678
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1249
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2267
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-23"
)
public class Solution2116 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) == 1) {
            return false;
        }
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                if (low > 0) { // can be a right bracket only if there is a left one to match
                    low--;
                } else { // otherwise be a left bracket
                    low = 1;
                }
                high++; // be a left bracket
            } else if (s.charAt(i) == '(') {
                low++;
                high++;
            } else {
                if (low == 0) { // change one unlocked right bracket to left bracket
                    low = 1;
                } else {
                    low--;
                }
                high--;
                if (high < 0) {
                    return false;
                }
            }
        }
        return low == 0;
    }
}