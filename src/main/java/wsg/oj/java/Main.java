package wsg.oj.java;

/**
 * @author Kingen
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("0".matches("0+"));
    }

    static class Node {
        private int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }
    }
}
