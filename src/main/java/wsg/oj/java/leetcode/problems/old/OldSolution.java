package wsg.oj.java.leetcode.problems.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * todo
 *
 * @author Kingen
 * @since 2021/6/15
 */
public class OldSolution {

    /**
     * 4.
     *
     * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4.
     * 寻找两个正序数组的中位数</a>
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 * len2 == 0) {
            int[] nums = len1 == 0 ? nums2 : nums1;
            int len = nums.length;
            if (len % 2 == 0) {
                return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
            } else {
                return nums[len / 2];
            }
        }

        int left1 = 0, left2 = 0;
        return 0.0;
    }

    // 554.
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> times = new HashMap<>();
        for (List<Integer> list : wall) {
            int size = list.size();
            if (size > 1) {
                int sum = list.get(0);
                if (times.containsKey(sum)) {
                    times.put(sum, times.get(sum) + 1);
                } else {
                    times.put(sum, 1);
                }
                for (int i = 1; i < size - 1; i++) {
                    sum += list.get(i);
                    if (times.containsKey(sum)) {
                        times.put(sum, times.get(sum) + 1);
                    } else {
                        times.put(sum, 1);
                    }
                }
            }
        }
        int max = 0;
        for (Integer value : times.values()) {
            if (value > max) {
                max = value;
            }
        }

        return wall.size() - max;
    }

    // 593.
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int len12 = getDistance(p1, p2);
        int len13 = getDistance(p1, p3);
        int len14 = getDistance(p1, p4);
        if (len13 > len12) {
            return isValidSquare(p1, p2, p3, p4, len13, len12, len14);
        }
        if (len14 > len12) {
            return isValidSquare(p1, p2, p4, p3, len14, len12, len13);
        }
        if (len12 > 0) {
            return isValidSquare(p1, p3, p2, p4, len12, len13, len14);
        }
        return false;
    }

    private boolean isValidSquare(int[] p1, int[] p2, int[] p3, int[] p4, int len13, int len12,
        int len14) {
        return (p1[0] + p3[0]) == (p2[0] + p4[0]) && (p1[1] + p3[1]) == (p2[1] + p4[1])
            && len13 == getDistance(p2, p4) && len12 == len14;
    }

    private int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

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
