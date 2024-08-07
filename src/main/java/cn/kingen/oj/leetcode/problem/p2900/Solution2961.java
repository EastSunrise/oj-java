package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

import static cn.kingen.oj.leetcode.util.MathUtils.fastPow;

/**
 * <a href="https://leetcode.cn/problems/double-modular-exponentiation/">2961. Double Modular Exponentiation</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2961 {

    @Complexity(time = "O(n*log{v})", space = "O(1)", note = "v is the maximum of variables")
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            if (fastPow(fastPow(a % 10, b, 10) % m, c, m) == target) {
                ans.add(i);
            }
        }
        return ans;
    }
}