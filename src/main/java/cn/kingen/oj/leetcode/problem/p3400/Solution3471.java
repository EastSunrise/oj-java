package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-the-largest-almost-missing-integer/">3471. Find the Largest Almost Missing Integer</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution268

 */
@Question(
        difficulty = Difficulty.EASY,
        contest = 439
)
public class Solution3471 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int ans = -1;
            for (int num : nums) {
                if (freq.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }
            return ans;
        }

        if (k == n) {
            int ans = -1;
            for (int num : nums) {
                ans = Math.max(ans, num);
            }
            return ans;
        }

        int first = nums[0], last = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] == first) {
                first = -1;
                break;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == last) {
                last = -1;
                break;
            }
        }
        return Math.max(first, last);
    }
}