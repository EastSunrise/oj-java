package wsg.oj.java.leetcode.problems.old;

/**
 * @author Kingen
 */
public class ListSolution {

    // 109. 有序链表转换二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = slow;
        while (fast.next != null && fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        TreeNode node = new TreeNode(cur.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(cur.next);
        return node;
    }

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

    // 147. 对链表进行插入排序
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode header = new ListNode(-1);
        header.next = head;
        int preCount = 1;
        for (ListNode node = head.next, last = head; node != null; preCount++) {
            ListNode pre = header;
            int count = preCount;
            while (count-- > 0 && node.val > pre.next.val) {
                pre = pre.next;
            }
            if (count >= 0) {
                last.next = node.next;
                node.next = pre.next;
                pre.next = node;
            } else {
                last = last.next;
            }
            node = last.next;
        }
        return header.next;
    }

    // 148. 排序链表
    public ListNode sortList(ListNode head) {
        // quick sort
        if (head == null) {
            return null;
        }
        ListNode leftHead = new ListNode(-1), rightHead = new ListNode(-1),
            left = leftHead, right = rightHead;
        int value = head.val;
        for (ListNode node = head.next; node != null; node = node.next) {
            if (node.val < value) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
        }
        left.next = right.next = null;
        leftHead.next = sortList(leftHead.next);
        head.next = sortList(rightHead.next);
        for (left = leftHead; left.next != null; left = left.next) {
        }
        left.next = head;
        return leftHead.next;
    }

    // 148. 排序链表
    public ListNode sortList1(ListNode head) {
        // merge sort
        if (head == null || head.next == null) {
            return head;
        }
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode slow = header;
        for (ListNode fast = header; fast != null && fast.next != null;
            slow = slow.next, fast = fast.next.next) {
        }
        ListNode right = sortList1(slow.next);
        slow.next = null;
        ListNode left = sortList1(head);
        for (slow = header; left != null && right != null; slow = slow.next) {
            if (left.val > right.val) {
                slow.next = right;
                right = right.next;
            } else {
                slow.next = left;
                left = left.next;
            }
        }
        if (left != null) {
            slow.next = left;
        }
        if (right != null) {
            slow.next = right;
        }
        return header.next;
    }
}
