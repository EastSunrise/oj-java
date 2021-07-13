package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution113;

/**
 * 257. Binary Tree Paths (Easy)
 *
 * @author Kingen
 * @see Solution113
 * @see Solution988
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-paths/">Binary Tree Paths</a>
 * @since 2021-07-13
 */
public class Solution257 implements Solution {

    /**
     * @complexity T=O(h*2^h), h=height of the tree
     * @complexity S=O(h*2^h)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> res = new ArrayList<>(left.size() + right.size());
        for (String path : left) {
            StringBuilder sb = new StringBuilder().append(root.val).append("->").append(path);
            res.add(sb.toString());
        }
        for (String path : right) {
            StringBuilder sb = new StringBuilder().append(root.val).append("->").append(path);
            res.add(sb.toString());
        }
        if (res.isEmpty()) {
            res.add(String.valueOf(root.val));
        }
        return res;
    }
}
