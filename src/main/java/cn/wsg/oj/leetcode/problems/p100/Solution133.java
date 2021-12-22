package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph (Medium)
 *
 * @author Kingen
 * @see Solution138
 * @see Solution1485
 * @see Solution1490
 * @see <a href="https://leetcode-cn.com/problems/clone-graph/">Clone Graph</a>
 */
public class Solution133 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraph(node, new HashMap<>(16));
    }

    private Node cloneGraph(Node node, Map<Integer, Node> cloned) {
        Node copy = cloned.get(node.val);
        if (copy != null) {
            return copy;
        }
        copy = new Node(node.val);
        cloned.put(node.val, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor, cloned));
        }
        return copy;
    }

    static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
