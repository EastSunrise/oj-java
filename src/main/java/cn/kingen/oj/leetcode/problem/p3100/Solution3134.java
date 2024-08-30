package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-the-median-of-the-uniqueness-array/">3134. Find the Median of the Uniqueness Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution719
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2262
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.HARD
)
public class Solution3134 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int medianOfUniquenessArray(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }

        int n = nums.length;
        int low = 1, high = distinct.size();
        long half = ((long) n * (n + 1) / 2 + 1) / 2;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countLargerThan(nums, mid, half)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean countLargerThan(int[] nums, int target, long median) {
        int n = nums.length;
        long cnt = 0;
        Map<Integer, Integer> window = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n) { // add nums[j] to window until window size is larger than target
                int num = nums[j];
                if (window.containsKey(num)) {
                    window.merge(num, 1, Integer::sum);
                    j++;
                } else if (window.size() < target) {
                    window.put(num, 1);
                    j++;
                } else {
                    break;
                }
            }
            cnt += j - i; // count of matched sub-arrays starting with nums[i]
            if (window.get(nums[i]) == 1) {
                window.remove(nums[i]);
            } else {
                window.merge(nums[i], -1, Integer::sum);
            }
            if (cnt >= median) {
                return true;
            }
        }
        return false;
    }
}