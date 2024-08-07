package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * <a href="https://leetcode.cn/problems/binary-search-tree-iterator/">173. Binary Search Tree Iterator</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution94
 * @see cn.kingen.oj.leetcode.problem.p200.Solution251
 * @see cn.kingen.oj.leetcode.problem.p200.Solution281
 * @see cn.kingen.oj.leetcode.problem.p200.PeekingIterator
 * @see cn.kingen.oj.leetcode.problem.p200.Solution285
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DESIGN, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE, Tag.ITERATOR},
        difficulty = Difficulty.MEDIUM
)
public class BSTIterator {

    private final Deque<TreeNode> stack = new ArrayDeque<>();

    @Complexity(time = "O(h)", space = "O(h)")
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    @Complexity(time = "O(h)", space = "O(1)")
    public int next() {
        TreeNode t = stack.pop();
        int val = t.val;
        t = t.right;
        while (t != null) {
            stack.push(t);
            t = t.left;
        }
        return val;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}