package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/strobogrammatic-number/">246. Strobogrammatic Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution247
 * @see cn.kingen.oj.leetcode.problem.p200.Solution248
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1056
 */
@Question(
        paidOnly = true,
        tags = {Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution246 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        while (i < j) {
            char a = num.charAt(i), b = num.charAt(j);
            if (a == '6' && b == '9' || a == '9' && b == '6' || a == '8' && b == '8' || a == '1' && b == '1' || a == '0' && b == '0') {
                i++;
                j--;
            } else {
                return false;
            }
        }
        if (i == j) {
            char a = num.charAt(i);
            return a == '8' || a == '1' || a == '0';
        }
        return true;
    }
}