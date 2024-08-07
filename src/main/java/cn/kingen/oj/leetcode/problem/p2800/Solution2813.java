package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/maximum-elegance-of-a-k-length-subsequence/">2813. Maximum Elegance of a K-Length Subsequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution502
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution2813 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        long sum = 0;
        Set<Integer> categories = new HashSet<>(k);
        // categories that appear more than once
        Deque<Integer> duplicates = new ArrayDeque<>(k);
        for (int i = n - 1; i >= n - k; i--) {
            sum += items[i][0];
            if (!categories.add(items[i][1])) { // duplicate category
                duplicates.push(items[i][0]);
            }
        }

        long ans = sum + (long) categories.size() * categories.size();
        for (int i = n - k - 1; i >= 0 && !duplicates.isEmpty() && categories.size() < k; i--) {
            if (categories.add(items[i][1])) { // different category
                sum += items[i][0] - duplicates.pop();
                ans = Math.max(ans, sum + (long) categories.size() * categories.size());
            }
        }
        return ans;
    }
}