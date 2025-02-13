package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/">1760. Minimum Limit of Balls in a Bag</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2226
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2064

 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-12"
)
public class Solution1760 {

    @Complexity(time = "O(n*log(m))", space = "O(1)", note = "m is the maximum of nums")
    public int minimumSize(int[] nums, int maxOperations) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        int left = (int) ((sum - 1) / (nums.length + maxOperations) + 1), right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(nums, maxOperations, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int k, int limit) {
        int op = 0;
        for (int num : nums) {
            op += (num - 1) / limit;
            if (op > k) {
                return false;
            }
        }
        return true;
    }
}