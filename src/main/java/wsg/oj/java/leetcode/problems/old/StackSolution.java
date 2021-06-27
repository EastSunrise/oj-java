package wsg.oj.java.leetcode.problems.old;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author Kingen
 */
public class StackSolution {

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

    // 331. 验证二叉树的前序序列化
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int count = 0;
        for (int i = nodes.length - 1; i >= 0; i--) {
            String node = nodes[i];
            if ("#".equals(node)) {
                count++;
            } else {
                if (count < 2) {
                    return false;
                }
                count--;
            }
        }
        return count == 1;
    }

    // 385. 迷你语法分析器
    public NestedInteger deserialize(String s) {
        char[] chars = ("[" + s + "]").toCharArray();
        Stack<Object> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            switch (c) {
                case '[':
                    stack.push("[");
                    break;
                case ',':
                    if (builder.length() > 0) {
                        stack.add(new NestedInteger(Integer.parseInt(builder.toString())));
                    }
                    builder = new StringBuilder();
                    break;
                case ']':
                    if (builder.length() > 0) {
                        stack.add(new NestedInteger(Integer.parseInt(builder.toString())));
                    }
                    builder = new StringBuilder();
                    Stack<NestedInteger> temp = new Stack<>();
                    for (Object object = stack.pop(); object instanceof NestedInteger;
                        object = stack.pop()) {
                        temp.push((NestedInteger) object);
                    }
                    NestedInteger nestedInteger = new NestedInteger();
                    while (!temp.empty()) {
                        nestedInteger.add(temp.pop());
                    }
                    stack.push(nestedInteger);
                    break;
                default:
                    builder.append(c);
            }
        }
        return ((NestedInteger) stack.pop()).getList().get(0);
    }

    // 394. 字符串解码
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> counts = new Stack<>();
        Stack<String> contents = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c == '[') {
                contents.push("[");
                counts.push(Integer.valueOf(builder.toString()));
                builder = new StringBuilder();
            } else if (c == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                for (String str = contents.pop(); !"[".equals(str); str = contents.pop()) {
                    stringBuilder.insert(0, str);
                }
                stringBuilder.append(builder.toString());
                builder = new StringBuilder();
                String str = stringBuilder.toString();
                int count = counts.pop();
                while (--count > 0) {
                    stringBuilder.append(str);
                }
                contents.push(stringBuilder.toString());
            } else if (c >= '0' && c <= '9') {
                builder.append(c);
            } else {
                contents.push(String.valueOf(c));
            }
        }
        builder = new StringBuilder();
        while (!contents.empty()) {
            builder.insert(0, contents.pop());
        }
        return builder.toString();
    }

    // 402. 移掉K位数字
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        char[] chars = num.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : chars) {
            if (k > 0) {
                while (!queue.isEmpty() && c < queue.peekLast() && k > 0) {
                    queue.pollLast();
                    k--;
                }
            }
            queue.addLast(c);
        }
        while (k-- > 0) {
            queue.pollLast();
        }
        while (!queue.isEmpty() && queue.element() == '0') {
            queue.pop();
        }
        if (queue.isEmpty()) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.pop());
        }
        return builder.toString();
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
}
