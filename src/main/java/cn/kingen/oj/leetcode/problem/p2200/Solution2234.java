package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-total-beauty-of-the-gardens/">2234. Maximum Total Beauty of the Gardens</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution410

 */
@Question(
    tags = {Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
    difficulty = Difficulty.HARD,
    date = "2025-03-08"
)
public class Solution2234 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        Arrays.sort(flowers);
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (flowers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0) {
            return (long) full * n;
        }

        // sums[i] is the least flowers to make flowers[i] as the minimum
        long[] sums = new long[high + 1];
        for (int i = 1; i <= high; i++) {
            sums[i] = sums[i - 1] + (long) (flowers[i] - flowers[i - 1]) * i;
        }

        long ans = 0;
        long leftFlowers = newFlowers;
        for (int i = high; i >= 0 && leftFlowers >= 0; i--) { // flowers[i+1:n] are complete and fill the previous ones with left flowers
            int left = 0, right = i;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (sums[mid] <= leftFlowers) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            long minCnt = Math.min(flowers[right] + (leftFlowers - sums[right]) / left, target - 1); // the min of partial ones
            ans = Math.max(ans, (long) full * (n - i - 1) + (long) partial * minCnt);

            leftFlowers -= target - flowers[i];
        }
        if (leftFlowers >= 0) {
            ans = Math.max(ans, (long) full * n);
        }
        return ans;
    }
}