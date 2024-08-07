package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/valid-mountain-array/">941. Valid Mountain Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1671
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2865
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution941 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 1;
        while (i < n && arr[i] > arr[i - 1]) {
            i++;
        }
        if (i == 1 || i == n) {
            return false;
        }
        while (i < n && arr[i] < arr[i - 1]) {
            i++;
        }
        return i == n;
    }
}