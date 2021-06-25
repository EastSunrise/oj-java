package wsg.oj.java.leetcode.problems;

/**
 * @author Kingen
 * @since 2021/6/15
 */
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode parse(String input) {
        // Generate array from the input
        int[] nodeValues = TestUtil.stringToIntArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        ListNode node = this;
        do {
            builder.append(node.val).append(", ");
            node = node.next;
        } while (node != null);
        return builder.substring(0, builder.length() - 2) + "]";
    }
}
