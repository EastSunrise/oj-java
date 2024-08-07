package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/baseball-game/">682. Baseball Game</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1598
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution682 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int calPoints(String[] operations) {
        Deque<Integer> points = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "C" -> points.removeLast();
                case "D" -> points.offerLast(points.getLast() * 2);
                case "+" -> {
                    int last = points.removeLast();
                    int current = last + points.getLast();
                    points.offerLast(last);
                    points.offerLast(current);
                }
                default -> points.offerLast(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return sum;
    }
}