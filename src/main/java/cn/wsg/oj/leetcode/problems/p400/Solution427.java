package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 427. Construct Quad Tree (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/construct-quad-tree/">Construct Quad Tree</a>
 */
public class Solution427 implements Solution {

    /**
     * @see Complexity#TIME_NN
     */
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int top, int left, int len) {
        if (len == 1) {
            return new Node(grid[top][left] == 1, true);
        }
        len /= 2;
        Node topLeft = construct(grid, top, left, len);
        Node botLeft = construct(grid, top + len, left, len);
        Node topRight = construct(grid, top, left + len, len);
        Node botRight = construct(grid, top + len, left + len, len);
        if (topLeft.isLeaf && botLeft.isLeaf && topRight.isLeaf && botRight.isLeaf) {
            if (topLeft.val && botLeft.val && topRight.val && botRight.val) {
                return new Node(true, true);
            }
            if (!topLeft.val && !botLeft.val && !topRight.val && !botRight.val) {
                return new Node(false, true);
            }
        }
        return new Node(false, false, topLeft, topRight, botLeft, botRight);
    }

    /**
     * Definition for a QuadTree node.
     */
    private static class Node {

        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
            Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
