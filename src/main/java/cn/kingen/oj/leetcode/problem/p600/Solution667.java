package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/beautiful-arrangement-ii/">667. Beautiful Arrangement II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution526
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution667 {

    /**
     * Constructs the array like: 1,k+1,2,k,3,k-1,4,k-2,...,k/2, k+2,k+3,...,n.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 0, low = 1, high = k + 1;
        while (low < high) {
            ans[i++] = low++;
            ans[i++] = high--;
        }
        if (low == high) {
            ans[i++] = low;
        }
        int val = k + 2;
        while (i < n) {
            ans[i++] = val++;
        }
        return ans;
    }
}