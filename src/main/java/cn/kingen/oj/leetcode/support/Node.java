package cn.kingen.oj.leetcode.support;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a Node.
 */
public class Node {

    public final int val;
    public List<Node> children;

    Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
