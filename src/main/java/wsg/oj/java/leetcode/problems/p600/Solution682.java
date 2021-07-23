package wsg.oj.java.leetcode.problems.p600;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 682. Baseball Game (EASY)
 *
 * @author Kingen
 * @see Solution1598
 * @see <a href="https://leetcode-cn.com/problems/baseball-game/">Baseball Game</a>
 * @since 2021-07-23
 */
class Solution682 implements Solution {

    public int calPoints(String[] ops) {
        Stack<Integer> points = new Stack<>();
        int i = 0;
        for (String op : ops) {
            if ("C".equals(op)) {
                points.pop();
            } else if ("D".equals(op)) {
                points.push(points.peek() * 2);
            } else if ("+".equals(op)) {
                int point = points.pop() + points.peek();
                points.push(point - points.peek());
                points.push(point);
            } else {
                points.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return sum;
    }
}
