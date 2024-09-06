package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-chairs-in-a-waiting-room/">3168. Minimum Number of Chairs in a Waiting Room</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1446
 */
@Question(
        tags = {Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution3168 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minimumChairs(String s) {
        int n = s.length();
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'E') {
                sum++;
            } else {
                sum--;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}