package cn.wsg.oj.leetcode.problems.p1200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p700.Solution705;
import cn.wsg.oj.leetcode.problems.p700.Solution706;
import cn.wsg.oj.leetcode.problems.p700.Solution707;

/**
 * 1206. Design Skiplist (HARD)
 *
 * @author Kingen
 * @see Solution705
 * @see Solution706
 * @see Solution707
 * @see <a href="https://leetcode-cn.com/problems/design-skiplist/">Design Skiplist</a>
 */
public class Solution1206 implements Solution {

    static class Skiplist {

        Node root;
        int size;

        public Skiplist() {

        }

        public boolean search(int target) {
            return false;
        }

        public void add(int num) {

        }

        public boolean erase(int num) {
            return false;
        }

        static class Node {

            int val;
            Node next;
            Node down;
        }
    }
}
