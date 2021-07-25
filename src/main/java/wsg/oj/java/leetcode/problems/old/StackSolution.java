package wsg.oj.java.leetcode.problems.old;


import java.util.Arrays;

/**
 * @author Kingen
 */
public class StackSolution {

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
