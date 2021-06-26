package wsg.oj.java.leetcode.problems;

/**
 * 705. Design HashSet (Easy)
 *
 * @author Kingen
 * @see MyHashMap
 * @see Skiplist
 * @see java.util.HashSet
 * @see <a href="https://leetcode-cn.com/problems/design-hashset/">Design HashSet</a>
 * @since 2021-06-25
 */
class MyHashSet {

    private final int bucket = 10009;
    private final Node[] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        table = new Node[bucket];
    }

    public void add(int key) {
        int hash = hash(key);
        Node node = table[hash];
        while (node != null) {
            if (node.key == key) {
                return;
            }
            node = node.next;
        }
        table[hash] = new Node(key, table[hash]);
    }

    public void remove(int key) {
        int hash = hash(key);
        Node node = table[hash];
        if (node == null) {
            return;
        }
        if (node.key == key) {
            table[hash] = node.next;
            return;
        }
        Node cur = node.next;
        while (cur != null) {
            if (cur.key == key) {
                node.next = cur.next;
                return;
            }
            node = cur;
            cur = cur.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = hash(key);
        Node node = table[hash];
        while (node != null && node.key != key) {
            node = node.next;
        }
        return node != null;
    }

    private int hash(int key) {
        return (key ^ (key >>> 10)) % bucket;
    }

    private static class Node {

        private final int key;
        private Node next;

        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }
}
