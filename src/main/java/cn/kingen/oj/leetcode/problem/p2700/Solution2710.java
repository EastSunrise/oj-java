package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/">2710. Remove Trailing Zeros From a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2980
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution2710 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i + 1);
    }
}