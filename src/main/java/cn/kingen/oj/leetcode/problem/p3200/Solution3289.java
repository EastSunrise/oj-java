package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/the-two-sneaky-numbers-of-digitville/">3289. The Two Sneaky Numbers of Digitville</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution442

 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH},
        difficulty = Difficulty.EASY,
        contest = 415
)
public class Solution3289 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] ans = {-1, -1};
        for (int i = 0; i < n; i++) {
            int p;
            while (i != (p = nums[i]) && p != nums[p]) { // switch nums[i] and nums[p]
                nums[i] = nums[p];
                nums[p] = p;
            }
            if (i != p) { // sneaky number
                if (ans[0] == -1) {
                    ans[0] = p;
                } else if (ans[0] != p) {
                    ans[1] = p;
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * @see cn.kingen.oj.leetcode.problem.p200.Solution260
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int[] getSneakyNumbers2(int[] nums) {
        int n = nums.length - 2;
        int xor = n ^ (n + 1);
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        int shift = Integer.numberOfTrailingZeros(xor);

        int[] ans = {0, 0};
        for (int i = 0; i < n; i++) {
            ans[i >> shift & 1] ^= i;
            ans[nums[i] >> shift & 1] ^= nums[i];
        }
        ans[nums[n] >> shift & 1] ^= nums[n];
        ans[nums[n + 1] >> shift & 1] ^= nums[n + 1];
        return ans;
    }
}