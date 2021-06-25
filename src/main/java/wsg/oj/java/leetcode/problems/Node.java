package wsg.oj.java.leetcode.problems;

import java.util.List;

/**
 * @author Kingen
 * @since 2021/6/19
 */
class Node {

    int val;
    List<Node> children;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
