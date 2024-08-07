package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-a-special-number/">2844. Minimum Operations to Make a Special Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution402
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2259
 */
@Question(
        tags = {Tag.GREEDY, Tag.MATH, Tag.STRING, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2844 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minimumOperations(String num) {
        int ans = num.length();
        int i = num.lastIndexOf('0');
        if (i >= 0) {
            int j = Math.max(num.lastIndexOf('0', i - 1), num.lastIndexOf('5', i - 1));
            if (j == -1) { // only '0' left
                ans = Math.min(ans, num.length() - 1);
            } else { // end with "00" or "50"
                ans = Math.min(ans, num.length() - 2 - j);
            }
        }
        i = num.lastIndexOf('5');
        if (i >= 0) {
            int j = Math.max(num.lastIndexOf('2', i - 1), num.lastIndexOf('7', i - 1));
            if (j >= 0) { // end with "25" or "75"
                ans = Math.min(ans, num.length() - 2 - j);
            }
        }
        return ans;
    }
}