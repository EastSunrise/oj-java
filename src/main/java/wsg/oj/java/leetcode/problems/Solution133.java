package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * @author Kingen
 * @since 2021/6/28
 */
public class Solution133 implements Solution {

    /**
     * 133. Clone Graph (Medium)
     *
     * @see #DFS
     * @see Solution138#copyRandomList(Solution138.Node)
     * @see Solution1401#copyRandomBinaryTree(TreeNode)
     * @see Solution1401#cloneTree(int)
     * @see <a href="https://leetcode-cn.com/problems/clone-graph/">Clone Graph</a>
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
