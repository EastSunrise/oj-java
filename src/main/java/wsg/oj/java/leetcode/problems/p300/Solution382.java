package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 382. Linked List Random Node (Medium)
 *
 * @author Kingen
 * @see Solution398
 * @see <a href="https://leetcode-cn.com/problems/linked-list-random-node/">Linked List Random
 * Node</a>
 * @since 2021-07-13
 */
class Solution382 implements Solution {


    private static class Solution {

        private final List<Integer> values;
        private final Random random = new Random();

        /**
         * @param head The linked list's head. Note that the head is guaranteed to be not null, so
         *             it contains at least one node.
         */
        public Solution(ListNode head) {
            values = new ArrayList<>();
            do {
                values.add(head.val);
                head = head.next;
            } while (head != null);
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Reservoir_sampling>Reservoir sampling</a>
     */
    private static class Solution2 {

        private final ListNode head;

        /**
         * @param head The linked list's head. Note that the head is guaranteed to be not null, so
         *             it contains at least one node.
         */
        public Solution2(ListNode head) {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int res = head.val;
            ListNode node = head.next;
            int count = 1;
            Random random = new Random();
            while (node != null) {
                count++;
                int d = random.nextInt(count);
                if (d == 0) {
                    res = node.val;
                }
                node = node.next;
            }
            return res;
        }
    }
}