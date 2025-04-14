package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-good-triplets/">1534. Count Good Triplets</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1995
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2475
 */
@Question(
    tags = {Tag.ARRAY, Tag.ENUMERATION},
    difficulty = Difficulty.EASY,
    date = "2025-04-14"
)
public class Solution1534 {

    @Complexity(time = "O(n^3)", space = "O(1)")
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int k = 2; k < arr.length; k++) {
            for (int j = 1; j < k; j++) {
                if (Math.abs(arr[j] - arr[k]) > b) {
                    continue;
                }
                for (int i = 0; i < j; i++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}