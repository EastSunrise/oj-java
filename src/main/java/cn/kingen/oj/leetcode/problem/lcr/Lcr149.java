package cn.kingen.oj.leetcode.problem.lcr;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/">LCR 149. 彩灯装饰记录 I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Lcr149 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] decorateRecord(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            ans.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}