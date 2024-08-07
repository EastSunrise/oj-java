package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/first-missing-positive/">41. First Missing Positive</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution268
 * @see cn.kingen.oj.leetcode.problem.p200.Solution287
 * @see cn.kingen.oj.leetcode.problem.p400.Solution448
 * @see cn.kingen.oj.leetcode.problem.p700.Solution765
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.HARD
)
public class Solution41 {

    /**
     * Sets nums[i]=i+1 if the array contains i+1, otherwise nums[i]=0.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num < 1 || num > n || nums[num - 1] == num) {
                continue;
            }
            nums[i] = 0;
            do {
                int tmp = nums[num - 1];
                nums[num - 1] = num;
                num = tmp;
            } while (num > 0 && num <= n && nums[num - 1] != num);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}