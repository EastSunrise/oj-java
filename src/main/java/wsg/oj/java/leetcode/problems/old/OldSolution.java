package wsg.oj.java.leetcode.problems.old;

import java.util.Stack;

/**
 * todo
 *
 * @author Kingen
 * @since 2021/6/15
 */
public class OldSolution {

    // 880.
    public String decodeAtIndex(String S, int K) {
        Stack<Object> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        long len = 0;
        for (char c : S.toCharArray()) {
            if (len >= K) {
                break;
            }
            if (c >= '0' && c <= '9') {
                if (stringBuilder.length() > 0) {
                    len += stringBuilder.length();
                    stack.push(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                stack.push(c - '0');
                len *= (c - '0');
            } else {
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length() > 0) {
            len += stringBuilder.length();
            stack.push(stringBuilder.toString());
        }
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof Integer) {
                int d = (int) object;
                len /= d;
                while (K > len) {
                    K -= len;
                }
            } else {
                String str = (String) object;
                if (K <= len - str.length()) {
                    len -= str.length();
                } else {
                    return String.valueOf(str.charAt((int) (K - len + str.length() - 1)));
                }
            }
        }
        return String.valueOf(S.charAt(K - 1));
    }

    public int minFlipsMonoIncr(String S) {
        int num = 0;
        for (char c : S.toCharArray()) {
            if (c == '0') {
                num++;
            }
        }
        int min = num;
        for (char c : S.toCharArray()) {
            if (c == '0') {
                num--;
            } else {
                num++;
            }
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) {
            return false;
        }
        int aMin = x[1], aMax = 0, bMin = x[2], bMax = x[0];
        int a = 0, b = 0;
        for (int i = 3; i < x.length; i++) {
            switch (i % 4) {
                case 0:
                    b += x[i];
                    if (b >= bMax) {
                        return true;
                    } else {
                        bMax = b;
                    }
                case 2:
                    b -= x[i];
                    if (b <= bMin) {
                        return true;
                    } else {
                        bMin = b;
                    }
                    break;
                case 1:
                    a -= x[i];
                    if (a <= aMin) {
                        return true;
                    } else {
                        aMin = a;
                    }
                case 3:
                    a += x[i];
                    if (a >= aMax) {
                        return true;
                    } else {
                        aMax = a;
                    }
                    break;
            }
        }
        // wsg
        return false;
    }

    // 0 <= src[i] < max
    public void bucketSort(int[] src, int max) {
        int[] times = new int[max];
        for (int i : src) {
            times[i]++;
        }
        int index = 0;
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            while (time-- > 0) {
                src[index++] = i;
            }
        }
    }

}
