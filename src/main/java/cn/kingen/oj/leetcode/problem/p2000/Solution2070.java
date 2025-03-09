package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/most-beautiful-item-for-each-query/">2070. Most Beautiful Item for Each Query</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1847
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2640
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2736

 */
@Question(
    tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.SORTING},
    difficulty = Difficulty.MEDIUM,
    date = "2025-03-09"
)
public class Solution2070 {

    @Complexity(time = "O((n+m)*log(n))", space = "O(n)")
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length, m = queries.length;
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int[] beauties = new int[n];
        int maxBeauty = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            beauties[i] = maxBeauty;
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int low = 0, high = n - 1, query = queries[i];
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (items[mid][0] <= query) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans[i] = high == -1 ? 0 : beauties[high];
        }
        return ans;
    }
}