package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-changing-keys/">3019. Number of Changing Keys</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY,
        date = "2025-01-07"
)
public class Solution3019 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int countKeyChanges(String s) {
        int n = s.length(), ans = 0;
        for (int i = 1; i < n; i++) {
            if ((s.charAt(i) & 31) != (s.charAt(i - 1) & 31)) {
                ans++;
            }
        }
        return ans;
    }
}