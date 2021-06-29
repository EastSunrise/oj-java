package wsg.oj.java.leetcode.problems.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Kingen
 */
public class MathSolution {

    // wsg 240. 搜索二维矩阵 II
    public boolean searchMatrix(int[][] matrix, int target) {
        int x1 = matrix.length - 1;
        if (x1 == -1) {
            return false;
        }
        int y1 = matrix[0].length - 1, x0 = 0, y0 = 0;
        while (x0 <= x1 && y0 <= y1) {
            int x = Arrays.binarySearch(matrix[y0], x0, x1, target);
            if (x >= 0) {
                return true;
            }
            x1 = -2 - x;
            if (x0 > x1) {
                return false;
            }
            x = Arrays.binarySearch(matrix[y1], x0, x1, target);
            if (x >= 0) {
                return true;
            }
            x0 = -1 - x;
            if (x0 > x1) {
                return false;
            }
            int y = binarySearchMatrix(matrix, x0, y0, y1, target);
            if (y >= 0) {
                return true;
            }
            y1 = -2 - y;
            if (y0 > y1) {
                return false;
            }
            y = binarySearchMatrix(matrix, x1, y0, y1, target);
            if (y >= 0) {
                return true;
            }
            y0 = -1 - y;
        }
        return false;
    }

    private int binarySearchMatrix(int[][] matrix, int x, int y0, int y1, int target) {
        while (y0 <= y1) {
            int mid = (y0 + y1) >>> 1;
            int midVal = matrix[mid][x];

            if (midVal < target) {
                y0 = mid + 1;
            } else if (midVal > target) {
                y1 = mid - 1;
            } else {
                return mid;
            }
        }
        return -(y0 + 1);
    }

    // 368. 最大整除子集
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length], pre = new int[nums.length];
        Arrays.fill(pre, -1);
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int max = dp[0], index = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        List<Integer> list = new LinkedList<>();
        while (index != -1) {
            list.add(nums[index]);
            index = pre[index];
        }
        return list;
    }

    // 400. 第N个数字
    public int findNthDigit(int n) {
        int index = 1, count = 9, first = 1;
        while (n > count) {
            n -= count;
            count = (int) (Math.pow(10, index++) * index * 9);
            first = first * 10;
        }
        int target = first + (--n) / index;
        int pos = n % index;
        return Integer.parseInt(String.valueOf(target).substring(pos, pos + 1));
    }

    // 413. 等差数列划分
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] dif = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            dif[i - 1] = A[i] - A[i - 1];
        }
        int cur = dif[0], count = 1;
        List<Integer> counts = new LinkedList<>();
        for (int i = 1; i < dif.length; i++) {
            if (dif[i] == cur) {
                count++;
            } else {
                if (count > 1) {
                    counts.add(count);
                }
                cur = dif[i];
                count = 1;
            }
        }
        if (count > 1) {
            counts.add(count);
        }
        int res = 0;
        for (Integer c : counts) {
            res += c * (c - 1) >> 1;
        }
        return res;
    }

    // 416. 分割等和子集
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (nums.length == 1 || sum % 2 == 1) {
            return false;
        }
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }

    // 455. 分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }

    // 456. 132模式
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                min = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    // 462. 最少移动次数使数组元素相等 II
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int times = 0, mid = nums.length >> 1, median = nums[mid];
        for (int i = 0; i < mid; i++) {
            times += median - nums[i];
        }
        for (int i = mid + 1; i < nums.length; i++) {
            times += nums[i] - median;
        }
        return times;
    }

    // 494. 目标和
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, nums.length, S);
    }

    private int findTargetSumWays(int[] nums, int length, int target) {
        if (length == 1) {
            if (target == 0 && target == nums[0]) {
                return 2;
            } else if (target == nums[0] || target + nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return findTargetSumWays(nums, length - 1, target - nums[length - 1])
            + findTargetSumWays(nums, length - 1, target + nums[length - 1]);
    }

    // 633. 平方数之和
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum < c) {
                a++;
            } else if (sum > c) {
                b--;
            } else {
                return true;
            }
        }
        return false;
    }

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
