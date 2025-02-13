package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sort-array-by-parity-ii/">922. Sort Array By Parity II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution905
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2149
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2164
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2231
 */
@Question(
    tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING},
    difficulty = Difficulty.EASY,
        date = "2025-02-04"
)
public class Solution922 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length, tmp;
        for (int i = 0, j = 1; i < n && j < n; ) {
            if ((nums[i] & 1) == 0) {
                i += 2;
            } else if ((nums[j] & 1) == 1) {
                j += 2;
            } else {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}