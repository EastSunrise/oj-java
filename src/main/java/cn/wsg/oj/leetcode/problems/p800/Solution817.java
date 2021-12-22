package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/linked-list-components/">Linked List
 * Components</a>
 */
public class Solution817 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_N
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
