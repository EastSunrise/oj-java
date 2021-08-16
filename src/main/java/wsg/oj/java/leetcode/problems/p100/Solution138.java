package wsg.oj.java.leetcode.problems.p100;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 138. Copy List with Random Pointer (Medium)
 *
 * @author Kingen
 * @see Solution133
 * @see Solution1485
 * @see Solution1490
 * @see <a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">Copy List with
 * Random Pointer</a>
 * @since 2021-07-12
 */
public class Solution138 implements Solution {

    /**
     * Stores the random nodes with a map.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
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
