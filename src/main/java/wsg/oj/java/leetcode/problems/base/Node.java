package wsg.oj.java.leetcode.problems.base;

import java.util.List;

/**
 * Definition for a Node.
 *
 * @author Kingen
 * @since 2021/6/19
 */
public class Node {

    public int val;
    public List<Node> children;

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
