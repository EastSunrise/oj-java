package wsg.oj.java.leetcode.problems;

import java.util.*;

/**
 * @author Kingen
 */
public class MathSolution {

    private int guessNum = 6;

    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            int mod = n % 26;
            if (mod == 0)
                mod = 26;
            str.insert(0, (char) (64 + mod));
            n = (n - mod) / 26;
        }
        return str.toString();
    }

    public int majorityElement(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++)
            if (num == nums[i])
                count++;
            else if (count == 0) {
                count++;
                num = nums[i];
            } else
                count--;
        return num;
    }

    public int titleToNumber(String s) {
        int sum = 0;
        for (char c : s.toCharArray())
            sum = (c - 64) + sum * 26;
        return sum;
    }

    private int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (!set.add(n))
                return false;
            int sum = 0;
            while (n > 0) {
                int mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }

    // 231. 2的幂
    public boolean isPowerOfTwo(int n) {
        return isPowerOfN(n, 2);
    }

    // 263. 丑数
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        return num == 1;
    }

    // 326. 3的幂
    public boolean isPowerOfThree(int n) {
        return isPowerOfN(n, 3);
    }

    // 367. 有效的完全平方数
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int left = 2, right = num / 2;
        while (left < right) {
            right = (left + right) >> 1;
            left = num / right;
        }
        return right * right == num;
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

    // 441. 排列硬币
    public int arrangeCoins(int n) {
        int row = 0;
        while (n >= ++row)
            n -= row;
        return row - 1;
    }

    // 453. 最小移动次数使数组元素相等
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums)
            if (num < min)
                min = num;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum - min * nums.length;
    }

    // 598. 范围求和 II
    public int maxCount(int m, int n, int[][] ops) {
        int aMin = m, bMin = n;
        for (int[] op : ops) {
            if (op[0] < aMin)
                aMin = op[0];
            if (op[1] < bMin)
                bMin = op[1];
        }
        return aMin * bMin;
    }

    // 633. 平方数之和
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum < c)
                a++;
            else if (sum > c)
                b--;
            else
                return true;
        }
        return false;
    }

    // 645. 错误的集合
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, sum = 0, duplicate = 0;
        BitSet bitSet = new BitSet(n + 1);
        for (int num : nums)
            if (bitSet.get(num))
                duplicate = num;
            else {
                bitSet.set(num);
                sum += num;
            }
        return new int[]{duplicate, n * (n + 1) / 2 - sum};
    }

    // 728. 自除数
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDivides = new LinkedList<>();
        for (int i = left; i <= right; i++)
            if (isSelfDividingNumber(i))
                selfDivides.add(i);
        return selfDivides;
    }

    private boolean isSelfDividingNumber(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0)
                return false;
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{
                1, 3, 5
        }, 0));
    }

    // 868. 二进制间距
    public int binaryGap(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int lastIndex = 0, maxDist = 0;
        for (int i = 0; i < chars.length; i++)
            if (chars[i] == '1') {
                int dist = i - lastIndex;
                if (dist > maxDist)
                    maxDist = dist;
                lastIndex = i;
            }
        return maxDist;
    }

    // 883. 三维形体投影面积
    public int projectionArea(int[][] grid) {
        int top = 0, front = 0, left = 0;
        for (int[] ints : grid)
            for (int anInt : ints)
                if (anInt > 0)
                    top++;
        for (int[] ints : grid) {
            int rowMax = 0;
            for (int anInt : ints) {
                if (anInt > rowMax)
                    rowMax = anInt;
            }
            front += rowMax;
        }
        int[] colMaxes = new int[grid[0].length];
        int colIndex = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt > colMaxes[colIndex])
                    colMaxes[colIndex] = anInt;
                colIndex++;
            }
            colIndex = 0;
        }
        for (int colMax : colMaxes) {
            left += colMax;
        }
        return top + front + left;
    }

    // 892. 三维形体的表面积
    public int surfaceArea(int[][] grid) {
        int top = 0, front = 0, left = 0;
        for (int[] ints : grid)
            for (int anInt : ints)
                if (anInt > 0)
                    top += 2;
        for (int[] ints : grid) {
            front += ints[0];
            for (int i = 1; i < ints.length; i++)
                front += Math.abs(ints[i] - ints[i - 1]);
            front += ints[ints.length - 1];
        }
        int[] cols = grid[0];
        for (int col : cols)
            left += col;
        for (int[] ints : grid)
            for (int j = 0; j < ints.length; j++) {
                left += Math.abs(ints[j] - cols[j]);
                cols[j] = ints[j];
            }
        for (int col : cols)
            left += col;
        return top + front + left;
    }

    // 942. 增减字符串匹配
    public int[] diStringMatch(String S) {
        int N = S.length();
        char[] chars = S.toCharArray();
        int[] result = new int[N + 1];
        int low = 0, high = N;
        for (int i = 0; i < N; i++)
            result[i] = (chars[i] == 'I') ? low++ : high--;
        result[N] = low;
        return result;
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
            if (value / 100 < 24 && value % 100 < 60 && value > max)
                max = value;
        }
        if (max == -1)
            return "";
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

    public boolean isPowerOfFour(int num) {
        return isPowerOfN(num, 4);
    }

    private boolean isPowerOfN(int num, int N) {
        if (num <= 0)
            return false;
        while (num % N == 0)
            num /= N;
        return num == 1;
    }

    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 1, right = x;
        while (left < right) {
            right = left + ((right - left) >> 1);
            left = x / right;
        }
        return right;
    }

    // 374. 猜数字大小
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int res = guess(mid);
            if (res < 0)
                high = mid - 1;
            else if (res > 0)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private int guess(int num) {
        return Integer.compare(num, guessNum);
    }

    // 744. 寻找比目标字母大的最小字母
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters)
            if (letter > target)
                return letter;
        return letters[0];
    }

    // 961. 重复 N 次的元素
    private int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A)
            if (!set.add(a))
                return a;
        return 0;
    }

    // 258. 各位相加
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    // 455. 分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex])
                gIndex++;
            sIndex++;
        }
        return gIndex;
    }

    // 874. 模拟行走机器人
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) set.add((obstacle[0] << 16) + obstacle[1]);
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int direction = 0;
        int x = 0, y = 0;
        int max = 0;
        for (int command : commands) {
            if (command > 0) {
                for (int i = 0; i < command; i++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (set.contains((x << 16) + y)) {
                        x -= dx[direction];
                        y -= dy[direction];
                        break;
                    }
                }
                int dist = x * x + y * y;
                if (dist > max)
                    max = dist;
            } else
                direction = (direction + command * 2 + 7) % 4;
        }
        return max;
    }

    // 860. 柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills)
            if (bill == 5)
                count5++;
            else {
                if (bill == 10) {
                    count10++;
                    count5--;
                } else if (count10 > 0) {
                    count10--;
                    count5--;
                } else
                    count5 -= 3;
                if (count5 < 0)
                    return false;
            }
        return true;
    }

    // 50. Pow(x, n)
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n > 0) {
            if (n == 1)
                return x;
            double res = myPow(x, n >> 1);
            return res * res * (n % 2 == 0 ? 1 : x);
        } else return 1 / myPow(x, -(n + 1)) / x;
    }

    // 29. 两数相除
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE)
            if (dividend == Integer.MIN_VALUE)
                return 1;
            else
                return 0;
        int quotient = 0;
        if (dividend == Integer.MIN_VALUE)
            if (divisor == -1)
                return Integer.MAX_VALUE;
            else {
                dividend -= Math.abs(divisor);
                quotient++;
            }
        boolean sign = (dividend > 0) ^ (divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend > divisor) {
            dividend -= divisor;
            quotient++;
        }
        return sign ? -quotient : quotient;
    }

    // 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new LinkedList<>();
        if (nums.length < 3)
            return listList;
        Arrays.sort(nums);
        int a = nums[0] - 1, b, c;
        for (int i = 0; i < nums.length - 2; i++) {
            if (a == nums[i])
                continue;
            a = nums[i];
            int bIndex = i + 1, cIndex = nums.length - 1;
            while (bIndex < cIndex) {
                int sum = nums[bIndex] + nums[cIndex] + a;
                if (sum < 0) bIndex++;
                else if (sum > 0) cIndex--;
                else {
                    listList.add(Arrays.asList(a, nums[bIndex], nums[cIndex]));
                    while (++bIndex < cIndex && nums[bIndex] == nums[bIndex - 1]) ;
                    while (--cIndex > bIndex && nums[cIndex] == nums[cIndex + 1]) ;
                }
            }
        }
        return listList;
    }

    // 12. 整数转罗马数字
    public String intToRoman(int num) {
        char[] bases = new char[]{
                'I', 'V', 'X', 'L', 'C', 'D', 'M'
        };
        int bit = 0, digit;
        Stack<Character> stack = new Stack<>();
        do {
            digit = num % 10;
            if (digit != 0) {
                int mod = digit % 5;
                switch (mod) {
                    case 0:
                        stack.push(bases[bit + 1]);
                        break;
                    case 4:
                        stack.push(bases[bit + 1 + digit / 5]);
                        stack.push(bases[bit]);
                        break;
                    default:
                        while (mod-- > 0)
                            stack.push(bases[bit]);
                        if (digit / 5 == 1)
                            stack.push(bases[bit + 1]);
                }
            }
            num /= 10;
            bit += 2;
        } while (num > 0);
        StringBuilder builder = new StringBuilder();
        while (!stack.empty())
            builder.append(stack.pop());
        return builder.toString();
    }

    // 62. 不同路径
    public int uniquePaths(int m, int n) {
        return combination(m + n - 2, m - 1);
    }

    // m >= n >= 0
    private int combination(int m, int n) {
        if (n > m >> 1)
            return combination(m, m - n);
        if (n == 0)
            return 1;
        int gcd = gcd(m, n);
        return combination(m - 1, n - 1) / (n / gcd) * (m / gcd);
    }

    // m >= n >= 0
    private int gcd(int m, int n) {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }

    // 494. 目标和
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, nums.length, S);
    }

    private int findTargetSumWays(int[] nums, int length, int target) {
        if (length == 1)
            if (target == 0 && target == nums[0])
                return 2;
            else if (target == nums[0] || target + nums[0] == 0)
                return 1;
            else
                return 0;
        return findTargetSumWays(nums, length - 1, target - nums[length - 1])
                + findTargetSumWays(nums, length - 1, target + nums[length - 1]);
    }

    // 413. 等差数列划分
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int[] dif = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) dif[i - 1] = A[i] - A[i - 1];
        int cur = dif[0], count = 1;
        List<Integer> counts = new LinkedList<>();
        for (int i = 1; i < dif.length; i++)
            if (dif[i] == cur)
                count++;
            else {
                if (count > 1)
                    counts.add(count);
                cur = dif[i];
                count = 1;
            }
        if (count > 1)
            counts.add(count);
        int res = 0;
        for (Integer c : counts) res += c * (c - 1) >> 1;
        return res;
    }

    // 456. 132模式
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min)
                return true;
            while (!stack.isEmpty() && nums[i] > stack.peek())
                min = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }

    // 462. 最少移动次数使数组元素相等 II
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int times = 0, mid = nums.length >> 1, median = nums[mid];
        for (int i = 0; i < mid; i++) times += median - nums[i];
        for (int i = mid + 1; i < nums.length; i++) times += nums[i] - median;
        return times;
    }

    // 754. 到达终点数字
    public int reachNumber(int target) {
        if (target < 0)
            target = 0 - target;
        int n = (int) Math.ceil(Math.sqrt(2 * target + 0.25) - 0.5);// getEdge min(n) satisfying (n * (n + 1) / 2 >= target)
        int dif = n * (n + 1) / 2 - target;
        if (dif % 2 == 0)
            return n;
        return n + n % 2 + 1;
    }

    // 368. 最大整除子集
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1)
            return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length], pre = new int[nums.length];
        Arrays.fill(pre, -1);
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
        int max = dp[0], index = 0;
        for (int i = 1; i < dp.length; i++)
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        List<Integer> list = new LinkedList<>();
        while (index != -1) {
            list.add(nums[index]);
            index = pre[index];
        }
        return list;
    }

    // wsg 735. 行星碰撞
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int pre;
        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0)
                stack.push(asteroid);
            else
                while (!stack.isEmpty() && (pre = stack.pop()) > 0)
                    if (-asteroid == pre) break;
                    else if (-asteroid < pre) {
                        stack.push(pre);
                        break;
                    } else if (stack.isEmpty()) stack.push(asteroid);
        }
        int[] ret = new int[stack.size()];
        int index = stack.size();
        while (!stack.isEmpty())
            ret[--index] = stack.pop();
        return ret;
    }

    // 416. 分割等和子集
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (nums.length == 1 || sum % 2 == 1) return false;
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums)
            for (int j = sum; j >= num; j--)
                dp[j] = dp[j] || dp[j - num];
        return dp[sum];
    }

    // wsg 240. 搜索二维矩阵 II
    public boolean searchMatrix(int[][] matrix, int target) {
        int x1 = matrix.length - 1;
        if (x1 == -1) return false;
        int y1 = matrix[0].length - 1, x0 = 0, y0 = 0;
        while (x0 <= x1 && y0 <= y1) {
            int x = Arrays.binarySearch(matrix[y0], x0, x1, target);
            if (x >= 0) return true;
            x1 = -2 - x;
            if (x0 > x1) return false;
            x = Arrays.binarySearch(matrix[y1], x0, x1, target);
            if (x >= 0) return true;
            x0 = -1 - x;
            if (x0 > x1) return false;
            int y = binarySearchMatrix(matrix, x0, y0, y1, target);
            if (y >= 0) return true;
            y1 = -2 - y;
            if (y0 > y1) return false;
            y = binarySearchMatrix(matrix, x1, y0, y1, target);
            if (y >= 0) return true;
            y0 = -1 - y;
        }
        return false;
    }

    private int binarySearchMatrix(int[][] matrix, int x, int y0, int y1, int target) {
        while (y0 <= y1) {
            int mid = (y0 + y1) >>> 1;
            int midVal = matrix[mid][x];

            if (midVal < target)
                y0 = mid + 1;
            else if (midVal > target)
                y1 = mid - 1;
            else
                return mid;
        }
        return -(y0 + 1);
    }

    // wsg 881. 救生艇
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int index = Arrays.binarySearch(people, limit);
        index = index < 0 ? (-2 - index) : index - 1;
        int count = people.length - index + 1;
        int left = 0;
        while (left < index) {
            left = Arrays.binarySearch(people, left, index - 1, limit - people[index]);
            if (left == -1)
                count++;
            left++;
            index--;
        }
        return 0;
    }

    // 150. 逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens)
            switch (token) {
                case "+":
                    stack.push((stack.pop()) + stack.pop());
                    break;
                case "-":
                    int subtrahend = stack.pop();
                    stack.push(stack.pop() - subtrahend);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        return stack.pop();
    }
}
