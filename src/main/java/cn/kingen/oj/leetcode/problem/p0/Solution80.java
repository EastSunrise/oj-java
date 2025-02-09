package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">80. Remove Duplicates from Sorted
 * Array II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution26
 */
@Question(
    tags = {Tag.ARRAY, Tag.TWO_POINTERS},
    difficulty = Difficulty.MEDIUM,
    daily = "2025-02-09"
)
public class Solution80 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int cnt = 1, last = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[last]) {
                nums[++last] = nums[i];
                cnt = 1;
            } else if (cnt < 2) {
                nums[++last] = nums[i];
                cnt++;
            }
        }
        return last + 1;
    }
}