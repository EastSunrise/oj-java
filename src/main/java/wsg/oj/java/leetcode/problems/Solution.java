package wsg.oj.java.leetcode.problems;

import wsg.oj.java.leetcode.problems.list.ListNode;

import java.util.*;

/**
 * @author Kingen
 */
public class Solution {
    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n < 4)
            return 1;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = nums[2] = 2;
        int countIndex = 2, curIndex = 3;
        boolean isCurOne = true;
        do {
            int count = nums[countIndex++];
            int curNum = isCurOne ? 1 : 2;
            for (int i = 0; i < count; i++)
                nums[curIndex++] = curNum;
            isCurOne = !isCurOne;
        } while (curIndex < n);
        int sum1 = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1)
                sum1++;
        return sum1;
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] <= nums[right])
                return nums[left];
            int mid = (left + right) >> 1;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                return nums[mid];
        }
        return nums[right];
    }

    public int calculate(String s) {
        Stack<String> operation = new Stack<>();
        Stack<String> temp = new Stack<>();
        Map<String, Integer> priority = new HashMap<>() {{
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
        }};

        Stack<String> src = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != ' ') {
                if (priority.containsKey(String.valueOf(aChar))) {
                    src.push(stringBuilder.toString());
                    src.push(String.valueOf(aChar));
                    stringBuilder = new StringBuilder();
                } else
                    stringBuilder.append(aChar);
            }
        }
        src.push(stringBuilder.toString());
        while (!src.empty()) {
            String unit = src.pop();
            if (priority.containsKey(unit)) {
                while (!operation.empty() && !(priority.get(unit) >= priority.get(operation.peek())))
                    temp.push(operation.pop());
                operation.push(unit);
            } else temp.push(unit);
        }
        while (!operation.empty())
            temp.push(operation.pop());
        while (!temp.empty())
            src.push(temp.pop());
        Stack<Integer> num = new Stack<>();
        while (!src.empty()) {
            String unit = src.pop();
            if (priority.containsKey(unit)) {
                int num1 = num.pop();
                int num2 = num.pop();
                switch (unit) {
                    case "+":
                        num.push(num1 + num2);
                        break;
                    case "*":
                        num.push(num1 * num2);
                        break;
                    case "-":
                        num.push(num1 - num2);
                        break;
                    case "/":
                        num.push(num1 / num2);
                        break;
                }
            } else
                num.push(Integer.valueOf(unit));
        }
        return num.pop();
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> times = new HashMap<>();
        for (List<Integer> list : wall) {
            int size = list.size();
            if (size > 1) {
                int sum = list.get(0);
                if (times.containsKey(sum))
                    times.put(sum, times.get(sum) + 1);
                else
                    times.put(sum, 1);
                for (int i = 1; i < size - 1; i++) {
                    sum += list.get(i);
                    if (times.containsKey(sum))
                        times.put(sum, times.get(sum) + 1);
                    else
                        times.put(sum, 1);
                }
            }
        }
        int max = 0;
        for (Integer value : times.values()) {
            if (value > max)
                max = value;
        }

        return wall.size() - max;
    }

    public String decodeAtIndex(String S, int K) {
        Stack<Object> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        long len = 0;
        for (char c : S.toCharArray()) {
            if (len >= K)
                break;
            if (c >= '0' && c <= '9') {
                if (stringBuilder.length() > 0) {
                    len += stringBuilder.length();
                    stack.push(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                stack.push(c - '0');
                len *= (c - '0');
            } else
                stringBuilder.append(c);
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
                while (K > len)
                    K -= len;
            } else {
                String str = (String) object;
                if (K <= len - str.length())
                    len -= str.length();
                else
                    return String.valueOf(str.charAt((int) (K - len + str.length() - 1)));
            }
        }
        return String.valueOf(S.charAt(K - 1));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            String toCompare = strs[i];
            while (index < result.length() && index < toCompare.length() && result.charAt(index) == toCompare.charAt(index)) {
                index++;
            }
            if (index == 0)
                return "";
            else
                result = result.substring(0, index);
        }
        return result;
    }

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        if (chars.length < 2)
            return S;
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] < 'A' || chars[left] > 'z' || (chars[left] > 'Z' && chars[left] < 'a'))
                left++;
            else if (chars[right] < 'A' || chars[right] > 'z' || (chars[right] > 'Z' && chars[right] < 'a'))
                right--;
            else {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        }
        return new String(chars);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int len12 = getDistance(p1, p2);
        int len13 = getDistance(p1, p3);
        int len14 = getDistance(p1, p4);
        if (len13 > len12)
            return isValidSquare(p1, p2, p3, p4, len13, len12, len14);
        if (len14 > len12)
            return isValidSquare(p1, p2, p4, p3, len14, len12, len13);
        if (len12 > 0) {
            return isValidSquare(p1, p3, p2, p4, len12, len13, len14);
        }
        return false;
    }

    private boolean isValidSquare(int[] p1, int[] p2, int[] p3, int[] p4, int len13, int len12, int len14) {
        return (p1[0] + p3[0]) == (p2[0] + p4[0]) && (p1[1] + p3[1]) == (p2[1] + p4[1])
                && len13 == getDistance(p2, p4) && len12 == len14;
    }

    private int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public int[] plusOne(int[] digits) {
        boolean carry = true;
        int len = digits.length;
        int index = len - 1;
        while (carry && index >= 0) {
            digits[index]++;
            if (digits[index] == 10)
                digits[index--] = 0;
            else
                carry = false;
        }
        if (!carry)
            return digits;
        int[] copy = new int[len + 1];
        copy[0] = 1;
        System.arraycopy(digits, 0, copy, 1, len);
        return copy;
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int height = matrix.length;
        if (height == 0) {
            return result;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return result;
        }
        Map<Integer, int[]> directionMap = new HashMap<Integer, int[]>() {{
            put(0, new int[]{0, 1});
            put(1, new int[]{1, 0});
            put(2, new int[]{0, -1});
            put(3, new int[]{-1, 0});
        }};
        boolean[][] hasOutput = new boolean[height][width];
        int direction = 0;
        int i = 0, j = 0;
        int blockTimes = 0;
        while (true) {
            int[] offset = directionMap.get(direction);
            if (i >= 0 && i < height && j >= 0 && j < width && !hasOutput[i][j]) {
                result.add(matrix[i][j]);
                hasOutput[i][j] = true;
                blockTimes = 0;
            } else {
                blockTimes++;
                if (blockTimes == 2)
                    break;
                i -= offset[0];
                j -= offset[1];
                direction = (direction + 1) % 4;
                offset = directionMap.get(direction);
            }
            i += offset[0];
            j += offset[1];
        }

        return result;
    }

    public int minFlipsMonoIncr(String S) {
        int num = 0;
        for (char c : S.toCharArray()) {
            if (c == '0')
                num++;
        }
        int min = num;
        for (char c : S.toCharArray()) {
            if (c == '0') {
                num--;
            } else
                num++;
            if (num < min)
                min = num;
        }
        return min;
    }

    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4)
            return false;
        int aMin = x[1], aMax = 0, bMin = x[2], bMax = x[0];
        int a = 0, b = 0;
        for (int i = 3; i < x.length; i++) {
            switch (i % 4) {
                case 0:
                    b += x[i];
                    if (b >= bMax)
                        return true;
                    else
                        bMax = b;
                case 2:
                    b -= x[i];
                    if (b <= bMin)
                        return true;
                    else
                        bMin = b;
                    break;
                case 1:
                    a -= x[i];
                    if (a <= aMin)
                        return true;
                    else
                        aMin = a;
                case 3:
                    a += x[i];
                    if (a >= aMax)
                        return true;
                    else
                        aMax = a;
                    break;
            }
        }
        // wsg
        return false;
    }

    public int distributeCandies(int[] candies) {
        BitSet bitSet = new BitSet(200001);
        for (int candy : candies) {
            candy += 100000;
            if (!bitSet.get(candy))
                bitSet.set(candy);
        }
        return Math.min(candies.length >> 1, bitSet.cardinality());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1, cursor2 = l2;
        ListNode listNode = new ListNode(0);
        ListNode cursor = listNode;
        while (cursor1 != null && cursor2 != null)
            if (cursor1.val < cursor2.val) {
                cursor.next = new ListNode(cursor1.val);
                cursor1 = cursor1.next;
                cursor = cursor.next;
            } else {
                cursor.next = new ListNode(cursor2.val);
                cursor2 = cursor2.next;
                cursor = cursor.next;
            }
        while (cursor1 != null) {
            cursor.next = new ListNode(cursor1.val);
            cursor1 = cursor1.next;
            cursor = cursor.next;
        }
        while (cursor2 != null) {
            cursor.next = new ListNode(cursor2.val);
            cursor2 = cursor2.next;
            cursor = cursor.next;
        }
        return listNode.next;
    }

    // 0 <= src[i] < max
    public void bucketSort(int[] src, int max) {
        int[] times = new int[max];
        for (int i : src)
            times[i]++;
        int index = 0;
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            while (time-- > 0)
                src[index++] = i;
        }
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int index = 0;
        while (index < len)
            if (nums[index] == val)
                nums[index] = nums[--len];
            else
                index++;
        return len;
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }

    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum ^= num;
        return sum;
    }

    // 412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3 && mod5)
                list.add("FizzBuzz");
            else if (!mod3 && !mod5)
                list.add(String.valueOf(i));
            else if (mod3)
                list.add("Fizz");
            else
                list.add("Buzz");
        }
        return list;
    }

    public static void main(String[] args) {
        new Solution().spiralOrder(new int[][]{});
    }
}
