package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 449. Serialize and Deserialize BST (Medium)
 *
 * @author Kingen
 * @see Solution297
 * @see Solution652
 * @see Solution428
 * @see <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-bst/">Serialize and
 * Deserialize BST</a>
 * @since 2021-07-08
 */
class Solution449 extends Solution {

    /**
     * @see #TO_OPTIMIZE
     */
    static class Codec {

        /**
         * Encodes a tree to a single string.
         */
        public String serialize(TreeNode root) {
            List<String> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                if (current == null) {
                    res.add("#");
                } else {
                    res.add(String.valueOf(current.val));
                    stack.push(current.right);
                    stack.push(current.left);
                }
            }
            return String.join(",", res);
        }

        /**
         * Decodes your encoded data to tree.
         */
        public TreeNode deserialize(String data) {
            return deserialize(data, new int[1]);
        }

        private TreeNode deserialize(String data, int[] start) {
            char ch = data.charAt(start[0]++);
            if (ch == '#') {
                start[0]++;
                return null;
            }
            StringBuilder value = new StringBuilder();
            do {
                value.append(ch);
                ch = data.charAt(start[0]++);
            } while (ch != ',');
            TreeNode left = deserialize(data, start);
            TreeNode right = deserialize(data, start);
            return new TreeNode(Integer.parseInt(value.toString()), left, right);
        }
    }

}
