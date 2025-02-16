package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/">1299. Replace Elements with Greatest Element on Right Side</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2078
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2454

 */
@Question(
    tags = {Tag.ARRAY},
    difficulty = Difficulty.EASY,
    date = "2025-02-16"
)
public class Solution1299 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] replaceElements(int[] arr) {
        int n = arr.length, max = -1, tmp;
        for (int i = n - 1; i >= 0; i--) {
            tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }
}