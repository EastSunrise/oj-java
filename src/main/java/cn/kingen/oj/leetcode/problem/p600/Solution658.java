package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-k-closest-elements/">658. Find K Closest Elements</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution374
 * @see cn.kingen.oj.leetcode.problem.p300.Solution375
 * @see cn.kingen.oj.leetcode.problem.p700.Solution719
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING, Tag.SLIDING_WINDOW, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution658 {

    @Complexity(time = "O(n-k)", space = "O(1)")
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        for (int i = k; i < n; i++) {
            int cmp = Math.abs(arr[low] - x) - Math.abs(arr[high] - x);
            if (cmp <= 0) {
                high--;
            } else {
                low++;
            }
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = low; i <= high; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}