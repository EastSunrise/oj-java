package wsg.oj.java.leetcode.problems.old;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Kingen
 */
public class StackSolution {

    // 32. 最长有效括号
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0, max = 0;
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            }

        }
        return 0;
    }

    // 503. 下一个更大元素 II
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return new int[0];
        }
        int[] temp = new int[len * 2], ret = new int[len];
        Arrays.fill(ret, -1);
        System.arraycopy(nums, 0, temp, 0, len);
        System.arraycopy(nums, 0, temp, len, len);
        for (int i = len; i < len * 2; i++) {
            if (temp[i] > temp[len - 1]) {
                ret[len - 1] = i;
                break;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (temp[i] == temp[i + 1]) {
                ret[i] = ret[i + 1];
            } else if (temp[i] < temp[i + 1]) {
                ret[i] = i + 1;
            } else {
                for (int j = ret[i + 1]; j < i + len; j++) {
                    if (temp[j] > temp[i]) {
                        ret[i] = j;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (ret[i] > -1) {
                ret[i] = nums[ret[i] % len];
            }
        }
        return ret;
    }

    // 636. 函数的独占时间
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> ids = new Stack<>();
        int[] ret = new int[n];
        int lastTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);
            if ("start".equals(parts[1])) {
                if (!ids.empty()) {
                    ret[ids.peek()] += time - lastTime;
                }
                ids.push(id);
                lastTime = time;
            } else {
                time++;
                ret[ids.pop()] += time - lastTime;
                lastTime = time;
            }
        }
        return ret;
    }

    // 739. 每日温度
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len < 1) {
            return new int[0];
        }
        int[] ret = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                ret[i] = 1;
            } else if (ret[i + 1] == 0) {
                ret[i] = 0;
            } else if (T[i] == T[i + 1]) {
                ret[i] = ret[i + 1] + 1;
            } else {
                for (int j = i + 1 + ret[i + 1]; j < len; j++) {
                    if (T[j] > T[i]) {
                        ret[i] = j - i;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    // 853. 车队
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }
        if (position.length == 1) {
            return 1;
        }
        int[] pos2Index = new int[target];
        Arrays.fill(pos2Index, -1);
        for (int i = 0; i < position.length; i++) {
            pos2Index[position[i]] = i;
        }
        int[] speeds = new int[speed.length];
        for (int pos = 0, i = 0; pos < pos2Index.length; pos++) {
            if (pos2Index[pos] >= 0) {
                position[i] = pos;
                speeds[i++] = speed[pos2Index[pos]];
            }
        }
        int preIndex = 0, count = 1;
        for (int i = 1; i < position.length; i++) {
            if ((target - position[i]) * speeds[preIndex] < speeds[i] * (target
                - position[preIndex])) {
                count++;
            }
            preIndex = i;
        }
        return count;
    }
}
