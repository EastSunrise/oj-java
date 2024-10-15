package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/">1884. Egg Drop With 2 Eggs and N Floors</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution887

 */
@Question(
    tags = {Tag.MATH, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM
)
public class Solution1884 {

    @Complexity(time = "O(sqrt(n))", space = "O(1)")
    public int twoEggDrop(int n) {
        int dp = 0;
        for (int i = 1; ; i++) {
            dp += i;
            if (dp >= n) {
                return i;
            }
        }
    }
}