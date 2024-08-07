package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-possible-full-binary-trees/">894. All Possible Full Binary Trees</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.RECURSION, Tag.MEMOIZATION, Tag.DYNAMIC_PROGRAMMING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution894 {

    @Complexity(time = "(2^n)/sqrt(n)", space = "O(1)")
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> dp = new ArrayList<>(n + 1);
        for (int i = n; i >= 0; i--) {
            dp.add(new ArrayList<>());
        }
        dp.get(1).add(new TreeNode(0));
        for (int i = 3; i <= n; i += 2) {
            for (int l = 1; l < i; l += 2) {
                int r = i - l - 1;
                for (TreeNode left : dp.get(l)) {
                    for (TreeNode right : dp.get(r)) {
                        dp.get(i).add(new TreeNode(0, left, right));
                    }
                }
            }
        }
        return dp.get(n);
    }
}