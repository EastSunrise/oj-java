package wsg.oj.java.structure;

/**
 * Binary tree data structure with linked nodes.
 *
 * @author Kingen
 */
public class LinkedBinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T t) {
        if (t == null) {
            return;
        }

        if (this.root == null) {
            this.root = new Node<>(t);
            return;
        }

        Node<T> current = this.root;
        while (true) {
            if (t.compareTo(current.key) <= 0) {
                if (current.left == null) {
                    current.left = new Node<>(t);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node<>(t);
                    return;
                }
                current = current.right;
            }
        }
    }

    private static class Node<T> {
        private final T key;
        private Node<T> left;
        private Node<T> right;

        public Node(T key) {
            this.key = key;
        }
    }
}
