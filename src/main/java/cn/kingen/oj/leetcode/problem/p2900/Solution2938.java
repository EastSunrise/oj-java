package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/separate-black-and-white-balls/">2938. Separate Black and White Balls</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2938 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long minimumSteps(String s) {
        int n = s.length();
        long k = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += i - k;
                k++;
            }
        }
        return ans;
    }
}