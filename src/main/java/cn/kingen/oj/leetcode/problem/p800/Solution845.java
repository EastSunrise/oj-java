package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-mountain-in-array/">845. Longest Mountain in Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1671
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2100
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.DYNAMIC_PROGRAMMING, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution845 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int longestMountain(int[] arr) {
        int n = arr.length, ans = 0;
        for (int i = 1; i < n; ) {
            if (arr[i - 1] >= arr[i]) {
                i++;
                continue;
            } // find an ascending sequence

            int j = i + 1;
            while (j < n && arr[j - 1] < arr[j]) {
                j++;
            } // arr[i-1] < a[i] < ... < a[j-1]

            int k = j;
            while (k < n && arr[k - 1] > arr[k]) {
                k++;
            } // a[j-1] > a[j] > ... > a[k-1]

            if (k > j) {
                ans = Math.max(ans, k - i + 1);
            }
            i = k;
        }
        return ans;
    }
}