package wsg.oj.java.leetcode.problems.p200;

import java.util.LinkedList;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p400.Solution449;
import wsg.oj.java.leetcode.problems.p600.Solution652;

/**
 * 297. Serialize and Deserialize Binary Tree (HARD)
 *
 * @author Kingen
 * @see Solution271
 * @see Solution449
 * @see Solution652
 * @see Solution428
 * @see <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">Serialize
 * and Deserialize Binary Tree</a>
 * @since 2021-07-27
 */
public class Solution297 implements Solution {

    /**
     * @see #LEVEL_ORDER
     */
    static class Codec {

        /**
         * Encodes a tree to a single string.
         */
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder builder = new StringBuilder();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node == null) {
                    builder.append("#,");
                    continue;
                }
                builder.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
            return builder.deleteCharAt(builder.length() - 1).toString();
        }

        /**
         * Decodes your encoded data to tree.
         */
        public TreeNode deserialize(String data) {
            if (data.length() == 0) {
                return null;
            }
            String[] parts = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while (!queue.isEmpty() && i < parts.length) {
                TreeNode node = queue.remove();
                String value = parts[i++];
                if (!"#".equals(value)) {
                    int left = Integer.parseInt(value);
                    node.left = new TreeNode(left);
                    queue.add(node.left);
                }
                if (i == parts.length) {
                    break;
                }
                value = parts[i++];
                if (!"#".equals(value)) {
                    int right = Integer.parseInt(value);
                    node.right = new TreeNode(right);
                    queue.add(node.right);
                }
            }
            return root;
        }
    }
}
