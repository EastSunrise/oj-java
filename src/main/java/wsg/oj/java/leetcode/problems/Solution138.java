package wsg.oj.java.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * @author Kingen
 * @since 2021/6/28
 */
public class Solution138 extends Solution {

    /**
     * 138. Copy List with Random Pointer (Medium)
     *
     * @see #HASHTABLE
     * @see Solution133#cloneGraph(Solution133.Node)
     * @see Solution1401#copyRandomBinaryTree(TreeNode)
     * @see Solution1401#cloneTree(int)
     * @see <a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">Copy List with
     * Random Pointer</a>
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node res = new Node(head.val);
        Map<Node, Node> map = new HashMap<>(16);
        map.put(head, res);
        Node source = head.next, copied = res;
        while (source != null) {
            Node copy = new Node(source.val);
            copied.next = copy;
            map.put(source, copy);
            source = source.next;
            copied = copied.next;
        }
        source = head;
        copied = res;
        do {
            if (source.random != null) {
                copied.random = map.get(source.random);
            }
            source = source.next;
            copied = copied.next;
        } while (source != null);
        return res;
    }

    static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
