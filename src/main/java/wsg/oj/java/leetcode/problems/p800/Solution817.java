package wsg.oj.java.leetcode.problems.p800;

import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 817. Linked List Components (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/linked-list-components/">Linked List
 * Components</a>
 * @since 2021-07-27
 */
public class Solution817 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            values.add(num);
        }
        boolean prev = false;
        int count = 0;
        while (head != null) {
            if (values.remove(head.val)) {
                if (!prev) {
                    count++;
                }
                prev = true;
            } else {
                prev = false;
            }
            head = head.next;
        }
        return count;
    }
}
