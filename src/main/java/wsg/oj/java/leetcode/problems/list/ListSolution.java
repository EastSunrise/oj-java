package wsg.oj.java.leetcode.problems.list;

import wsg.oj.java.leetcode.problems.ConvertUtils;
import wsg.oj.java.leetcode.problems.TreeNode;

import java.util.Stack;

/**
 * @author Kingen
 */
public class ListSolution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode last = head;
        ListNode cursor = head.next;
        while (cursor != null) {
            if (cursor.val == last.val)
                last.next = cursor.next;
            else
                last = cursor;
            cursor = cursor.next;
        }
        return head;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA, cursorB = headB;
        while (cursorA != cursorB) {
            cursorA = cursorA == null ? headB : cursorA.next;
            cursorB = cursorB == null ? headA : cursorB.next;
        }
        return cursorA;
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        if (head != null) {
            ListNode cursor = head;
            while (cursor.next != null)
                if (cursor.next.val == val)
                    cursor.next = cursor.next.next;
                else
                    cursor = cursor.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 234. 回文链表
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                break;
        }
        ListNode tail = reverseList(slow);
        while (tail != null)
            if (tail.val != head.val)
                return false;
            else {
                tail = tail.next;
                head = head.next;
            }
        return true;
    }

    // 237. 删除链表中的节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 19. 删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, ntd = head;
        while (n-- > 0)
            ntd = ntd.next;
        if (ntd == null)
            return head.next;
        while (ntd.next != null) {
            ntd = ntd.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    // 24. 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        // wsg
        return head;
    }

    // 61. 旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int size = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            size++;
        }
        k = size - k % size;
        last.next = head;
        while (k-- > 0) {
            last = head;
            head = head.next;
        }
        last.next = null;
        return head;
    }

    // 82. 删除排序链表中的重复元素 II
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = head, pre = header;
        while (cur != null) {
            ListNode next = cur.next;
            int count = 1, val = cur.val;
            while (next != null && next.val == val) {
                next = next.next;
                count++;
            }
            cur = next;
            if (count > 1) pre.next = next;
            else pre = pre.next;
        }
        return header.next;
    }

    // 92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pre = header;
        int count = n - m + 1;
        while (m-- > 1 && pre != null) pre = pre.next;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pre;
        while (count-- > 0 && cur != null) {
            cur = cur.next;
            stack.push(cur);
        }
        cur = cur.next;
        while (!stack.empty()) {
            pre.next = stack.pop();
            pre = pre.next;
        }
        pre.next = cur;
        return header.next;
    }

    // 109. 有序链表转换二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null)
            return new TreeNode(head.val);
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

    // 86. 分隔链表
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode right = partition(head.next, x);
        if (right == null) return head;
        if (head.val < x || right.val >= x) {
            head.next = right;
            return head;
        }
        ListNode node = right;
        while (node.next != null && node.next.val < x)
            node = node.next;
        ListNode next = node.next;
        node.next = head;
        head.next = next;
        return right;
    }

    // 23. 合并K个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKLists(lists, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int end) {
        if (end == 0)
            return lists[0];
        ListNode preNode = mergeKLists(lists, end - 1);
        ListNode node = lists[end];
        if (preNode == null)
            return node;
        if (node == null)
            return preNode;
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
        } else
            last.next = node;
        return head.next;
    }

    public static void main(String[] args) {
        new ListSolution().insertionSortList(ConvertUtils.stringToListNode("[4,2,1,3]"));
    }

    // 147. 对链表进行插入排序
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode header = new ListNode(-1);
        header.next = head;
        int preCount = 1;
        for (ListNode node = head.next, last = head; node != null; preCount++) {
            ListNode pre = header;
            int count = preCount;
            while (count-- > 0 && node.val > pre.next.val) pre = pre.next;
            if (count >= 0) {
                last.next = node.next;
                node.next = pre.next;
                pre.next = node;
            } else last = last.next;
            node = last.next;
        }
        return header.next;
    }

    // 148. 排序链表
    public ListNode sortList(ListNode head) {
        // quick sort
        if (head == null)
            return null;
        ListNode leftHead = new ListNode(-1), rightHead = new ListNode(-1),
                left = leftHead, right = rightHead;
        int value = head.val;
        for (ListNode node = head.next; node != null; node = node.next)
            if (node.val < value) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
        left.next = right.next = null;
        leftHead.next = sortList(leftHead.next);
        head.next = sortList(rightHead.next);
        for (left = leftHead; left.next != null; left = left.next) ;
        left.next = head;
        return leftHead.next;
    }

    // 148. 排序链表
    public ListNode sortList1(ListNode head) {
        // merge sort
        if (head == null || head.next == null) return head;
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode slow = header;
        for (ListNode fast = header; fast != null && fast.next != null;
             slow = slow.next, fast = fast.next.next)
            ;
        ListNode right = sortList1(slow.next);
        slow.next = null;
        ListNode left = sortList1(head);
        for (slow = header; left != null && right != null; slow = slow.next)
            if (left.val > right.val) {
                slow.next = right;
                right = right.next;
            } else {
                slow.next = left;
                left = left.next;
            }
        if (left != null) slow.next = left;
        if (right != null) slow.next = right;
        return header.next;
    }
}
