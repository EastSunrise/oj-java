package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/">331. Verify Preorder Serialization of a Binary Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.STRING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution331 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String s : preorder.split(",")) {
            if (slots == 0) {
                return false;
            }
            if (s.equals("#")) {
                slots--;
            } else {
                slots++;
            }
        }
        return slots == 0;
    }
}