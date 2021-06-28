package wsg.oj.java.leetcode.problems.old;

/**
 * @author Kingen
 */
public class ListSolution {

    // 23. 合并K个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int end) {
        if (end == 0) {
            return lists[0];
        }
        ListNode preNode = mergeKLists(lists, end - 1);
        ListNode node = lists[end];
        if (preNode == null) {
            return node;
        }
        if (node == null) {
            return preNode;
        }
        ListNode head = new ListNode(0);
        ListNode last = head;
        while (preNode != null && node != null) {
            if (preNode.val > node.val) {
                last.next = node;
                last = last.next;
                node = node.next;
            } else {
                last.next = preNode;
                last = last.next;
                preNode = preNode.next;
            }
        }
        if (preNode != null) {
            last.next = preNode;
        } else {
            last.next = node;
        }
        return head.next;
    }
}
