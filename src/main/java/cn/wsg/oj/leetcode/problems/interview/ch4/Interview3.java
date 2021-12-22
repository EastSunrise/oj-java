package cn.wsg.oj.leetcode.problems.interview.ch4;

import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 4.3. List of Depth LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/list-of-depth-lcci/">List of Depth LCCI</a>
 */
public class Interview3 implements Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        List<ListNode> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            ListNode head = new ListNode(0), prev = head;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                prev.next = new ListNode(cur.val);
                prev = prev.next;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            nodes.add(head.next);
        }
        return nodes.toArray(new ListNode[0]);
    }
}
