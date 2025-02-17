package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/">1287. Element Appearing More Than 25% In Sorted Array</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY,
        date = "2025-02-17"
)
public class Solution1287 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, limit = n / 4;
        for (int i = limit; i < n; i++) {
            if (arr[i - limit] == arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }
}