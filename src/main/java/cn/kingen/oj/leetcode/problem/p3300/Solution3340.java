package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/check-balanced-string/">3340. Check Balanced String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution110

 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY,
        date = "2025-03-14"
)
public class Solution3340 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isBalanced(String num) {
        int n = num.length(), diff = 0;
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            diff += (i & 1) == 0 ? digit : -digit;
        }
        return diff == 0;
    }
}