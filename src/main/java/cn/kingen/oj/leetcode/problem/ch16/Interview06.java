package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/smallest-difference-lcci/">面试题 16.06. Smallest Difference LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Interview06 {

    @Complexity(time = "O(m*log{m}+n*log{n})", space = "O(1)")
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int m = a.length, n = b.length;
        long ans = Long.MAX_VALUE;
        for (int i = 0, j = 0; i < m && j < n; ) {
            if (a[i] == b[j]) {
                return 0;
            } else if (a[i] < b[j]) {
                ans = Math.min(ans, (long) b[j] - a[i]);
                i++;
            } else {
                ans = Math.min(ans, (long) a[i] - b[j]);
                j++;
            }
        }
        return (int) ans;
    }
}