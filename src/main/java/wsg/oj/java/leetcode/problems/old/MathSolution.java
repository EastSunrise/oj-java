package wsg.oj.java.leetcode.problems.old;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Kingen
 */
public class MathSolution {

    // wsg 735. 行星碰撞
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int pre;
        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && (pre = stack.pop()) > 0) {
                    if (-asteroid == pre) {
                        break;
                    } else if (-asteroid < pre) {
                        stack.push(pre);
                        break;
                    } else if (stack.isEmpty()) {
                        stack.push(asteroid);
                    }
                }
            }
        }
        int[] ret = new int[stack.size()];
        int index = stack.size();
        while (!stack.isEmpty()) {
            ret[--index] = stack.pop();
        }
        return ret;
    }

    // 754. 到达终点数字
    public int reachNumber(int target) {
        if (target < 0) {
            target = -target;
        }
        int n = (int) Math.ceil(Math.sqrt(2 * target + 0.25)
            - 0.5);// getEdge min(n) satisfying (n * (n + 1) / 2 >= target)
        int dif = n * (n + 1) / 2 - target;
        if (dif % 2 == 0) {
            return n;
        }
        return n + n % 2 + 1;
    }

    // 881. 救生艇
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int index = Arrays.binarySearch(people, limit);
        index = index < 0 ? (-2 - index) : index - 1;
        int count = people.length - index + 1;
        int left = 0;
        while (left < index) {
            left = Arrays.binarySearch(people, left, index - 1, limit - people[index]);
            if (left == -1) {
                count++;
            }
            left++;
            index--;
        }
        return 0;
    }

    // 949. 给定数字能组成的最大时间
    public String largestTimeFromDigits(int[] A) {
        List<int[]> list = permutation(A, 0, 4);
        int max = -1;
        for (int[] ints : list) {
            int value = 0;
            for (int anInt : ints) {
                value = value * 10 + anInt;
            }
            if (value / 100 < 24 && value % 100 < 60 && value > max) {
                max = value;
            }
        }
        if (max == -1) {
            return "";
        }
        int hour = max / 100;
        int min = max % 100;
        return (hour < 10 ? "0" : "") + hour + ":" + (min < 10 ? "0" : "") + min;
    }

    private List<int[]> permutation(int[] src, int start, int end) {
        List<int[]> list = new LinkedList<>();
        if (end - start == 1) {
            list.add(src);
            return list;
        }
        for (int i = start; i < end; i++) {
            int temp = src[i];
            src[i] = src[start];
            src[start] = temp;
            list.addAll(permutation(Arrays.copyOf(src, src.length), start + 1, end));
        }
        return list;
    }
}
