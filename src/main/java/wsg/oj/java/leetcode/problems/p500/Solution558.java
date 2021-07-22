package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 558. Logical OR of Two Binary Grids Represented as Quad-Trees (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/">Logical
 * OR of Two Binary Grids Represented as Quad-Trees</a>
 * @since 2021-07-20
 */
class Solution558 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        if (!quadTree1.isLeaf && !quadTree2.isLeaf) {
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                if (topLeft.val == topRight.val && topRight.val == bottomLeft.val
                    && bottomLeft.val == bottomRight.val) {
                    return new Node(topLeft.val, true, null, null, null, null);
                }
            }
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        if (quadTree2.isLeaf) {
            Node tmp = quadTree1;
            quadTree1 = quadTree2;
            quadTree2 = tmp;
        }

        if (quadTree1.val) {
            return new Node(true, true, null, null, null, null);
        } else {
            return new Node(quadTree2.val, false, quadTree2.topLeft,
                quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
        }
    }

    /**
     * Definition for a QuadTree node.
     */
    static class Node {

        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
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
