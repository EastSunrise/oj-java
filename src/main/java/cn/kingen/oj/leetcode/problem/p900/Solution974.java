package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/subarray-sums-divisible-by-k/">974. Subarray Sums Divisible by K</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution560
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution974 {

    @Complexity(time = "O(n)", space = "O(k)")
    public int subarraysDivByK(int[] nums, int k) {
        int[] modules = new int[k];
        modules[0] = 1;
        int sum = 0, cnt = 0;
        for (int num : nums) {
            sum = Math.floorMod(sum + num, k);
            cnt += modules[sum];
            modules[sum]++;
        }
        return cnt;
    }
}