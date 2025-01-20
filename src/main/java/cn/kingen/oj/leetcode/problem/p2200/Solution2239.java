package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-closest-number-to-zero/">2239. Find Closest Number to Zero</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution658

 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution2239 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int dist = Math.abs(num);
            if (dist < min) {
                min = dist;
                ans = num;
            } else if (dist == min) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}