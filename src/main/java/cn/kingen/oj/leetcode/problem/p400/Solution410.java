package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum/">410. Split Array Largest Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1011
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1231
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2305
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2098
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2234
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2270
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2547
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3069
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3072
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.PREFIX_SUM},
        difficulty = Difficulty.HARD
)
public class Solution410 {

    @Complexity(time = "O(n*log{sum})", space = "O(1)")
    public int splitArray(int[] nums, int k) {
        int high = 0, low = 0;
        for (int num : nums) {
            high += num;
            low = Math.max(low, num);
        }
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isValid(nums, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isValid(int[] nums, int max, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
                k--;
                sum = num;
            }
        }
        return k >= 1;
    }
}