package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.401-No.500.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution401 extends Solution {

    /**
     * 401. Binary Watch (Easy)
     *
     * @see Solution1#letterCombinations(String)
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/binary-watch/">Binary Watch</a>
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int hCount = 0; hCount < 4; hCount++) {
            int minCount = turnedOn - hCount;
            if (minCount >= 0 && minCount < 6) {
                List<Integer> hours = possibles(4, hCount);
                List<Integer> minutes = possibles(6, minCount);
                for (Integer h : hours) {
                    if (h < 12) {
                        for (Integer min : minutes) {
                            if (min < 60) {
                                res.add(String.format("%d:%02d", h, min));
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<Integer> possibles(int digits, int bitCount) {
        // digits >= bitCount >= 0
        if (bitCount == 0) {
            return List.of(0);
        }
        List<Integer> possibles = possibles(digits - 1, bitCount - 1);
        List<Integer> res = new ArrayList<>(possibles.size());
        int base = (int) Math.pow(2, digits - 1);
        for (Integer possible : possibles) {
            res.add(base + possible);
        }
        if (digits > bitCount) {
            res.addAll(possibles(digits - 1, bitCount));
        }
        return res;
    }

    /**
     * 404. Sum of Left Leaves (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    /**
     * 405. Convert a Number to Hexadecimal (Easy)
     *
     * @see Integer#toHexString(int)
     * @see <a href="https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/">Convert a
     * Number to Hexadecimal</a>
     */
    public String toHex(int num) {
        return toNRadix(num, 4, 0xf);
    }

    private String toNRadix(int num, int shift, int base) {
        if (num == 0) {
            return "0";
        }
        // 0 < shift < 5
        char[] digits = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        StringBuilder builder = new StringBuilder(32 / shift);
        while (num != 0) {
            builder.insert(0, digits[num & base]);
            num >>>= shift;
        }
        return builder.toString();
    }

    /**
     * 409. Longest Palindrome (Easy)
     *
     * @see Solution201#canPermutePalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/longest-palindrome/">Longest Palindrome</a>
     */
    public int longestPalindrome(String s) {
        int[] single = new int[58];
        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            single[idx] = 1 - single[idx];
        }
        int singles = 0;
        for (int i : single) {
            singles += i;
        }
        return s.length() - singles + (singles > 0 ? 1 : 0);
    }

    /**
     * 412. Fizz Buzz (Easy)
     *
     * @see Solution1101#foobar(int)
     * @see <a href="https://leetcode-cn.com/problems/fizz-buzz/">Fizz Buzz</a>
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3) {
                if (mod5) {
                    res.add("FizzBuzz");
                } else {
                    res.add("Fizz");
                }
            } else {
                if (mod5) {
                    res.add("Buzz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
        }
        return res;
    }

    /**
     * 414. Third Maximum Number (Easy)
     *
     * @see Solution201#findKthLargest(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/third-maximum-number/">Third Maximum
     * Number</a>
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
        }
        Integer max2 = maxLessThan(nums, max);
        if (max2 == null) {
            return max;
        }
        Integer max3 = maxLessThan(nums, max2);
        return max3 == null ? max : max3;
    }

    private Integer maxLessThan(int[] nums, int n) {
        Integer max = null;
        for (int num : nums) {
            if (num < n) {
                if (max == null || max < num) {
                    max = num;
                }
            }
        }
        return max;
    }

    /**
     * 415. Add Strings (Easy)
     *
     * @see Solution1#addBinary(String, String)
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1#multiply(String, String)
     * @see Solution901#addToArrayForm(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/add-strings/">Add Strings</a>
     */
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i1 = chars1.length - 1, i2 = chars2.length - 1;
        char[] res = new char[Math.max(i1, i2) + 2];
        int i = res.length - 1, carry = 0;
        while (i1 >= 0 && i2 >= 0) {
            int sum = chars1[i1--] - '0' + chars2[i2--] - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        while (i1 >= 0) {
            int sum = chars1[i1--] - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        while (i2 >= 0) {
            int sum = chars2[i2--] - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[i] = (char) (carry + '0');
        return new String(res);
    }

    /**
     * 434. Number of Segments in a String (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-of-segments-in-a-string/">Number of
     * Segments in a String</a>
     */
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        int count = 0;
        while (i >= 0) {
            if (chars[i--] != ' ') {
                count++;
                while (i >= 0 && chars[i] != ' ') {
                    i--;
                }
            }
        }
        return count;
    }

    /**
     * 441. Arranging Coins (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/arranging-coins/">Arranging Coins</a>
     */
    public int arrangeCoins(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int dif = mid % 2 == 0 ? (mid / 2 - n / (mid + 1)) : ((mid + 1) / 2 - n / mid);
            if (dif > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     * 448. Find All Numbers Disappeared in an Array (Easy)
     *
     * @see Solution1#firstMissingPositive(int[])
     * @see Solution401#findDuplicates(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">Find
     * All Numbers Disappeared in an Array</a>
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                int value = nums[i];
                nums[i] = 0;
                while (value != 0 && nums[value - 1] != value) {
                    int temp = nums[value - 1];
                    nums[value - 1] = value;
                    value = temp;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 453. Minimum Moves to Equal Array Elements (Easy)
     *
     * @see Solution401#minMoves2(int[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/">Minimum
     * Moves to Equal Array Elements</a>
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }

    /**
     * 459. Repeated Substring Pattern (Easy)
     *
     * @see Solution1#strStr(String, String)
     * @see Solution601#repeatedStringMatch(String, String)
     * @see <a href="https://leetcode-cn.com/problems/repeated-substring-pattern/">Repeated
     * Substring Pattern</a>
     */
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int subLen = len / 2; subLen > 0; subLen--) {
            if (len % subLen == 0 && repeatedSubstringPattern(chars, len, subLen)) {
                return true;
            }
        }
        return false;
    }

    private boolean repeatedSubstringPattern(char[] chars, int len, int subLen) {
        for (int i = subLen; i < len; i++) {
            if (chars[i] != chars[i - subLen]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 461. Hamming Distance (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see Solution401#totalHammingDistance(int[])
     * @see <a href="https://leetcode-cn.com/problems/hamming-distance/">Hamming Distance</a>
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 476. Number Complement (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-complement/">Number Complement</a>
     */
    public int findComplement(int num) {
        int fff = 0;
        while (fff < num) {
            fff = fff * 2 + 1;
        }
        return num ^ fff;
    }

    /**
     * 482. License Key Formatting (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/license-key-formatting/">License Key
     * Formatting</a>
     */
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        int dashes = 0;
        for (char ch : chars) {
            if (ch == '-') {
                dashes++;
            }
        }
        int keysCount = chars.length - dashes;
        char[] res = new char[keysCount + (keysCount - 1) / k];
        int i = chars.length - 1, c = 0, j = res.length - 1;
        while (i >= 0) {
            char ch = chars[i--];
            if (ch != '-') {
                if (ch > 'Z') {
                    ch -= 32;
                }
                if (c == k) {
                    res[j--] = '-';
                    c = 0;
                }
                res[j--] = ch;
                c++;
            }
        }
        return new String(res);
    }

    /**
     * 485. Max Consecutive Ones (Easy)
     *
     * @see Solution401#findMaxConsecutiveOnes(int[])
     * @see Solution1001#longestOnes(int[], int)
     * @see Solution1401#maxPower(String)
     * @see Solution1801#checkZeroOnes(String)
     * @see <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">Max Consecutive
     * Ones</a>
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }

    /**
     * 492. Construct the Rectangle (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/construct-the-rectangle/">Construct the
     * Rectangle</a>
     */
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        while (area % W != 0) {
            W--;
        }
        return new int[]{area / W, W};
    }

    /**
     * 495. Teemo Attacking (Easy)
     *
     * @see Solution1#merge(int[][])
     * @see Solution601#canPlaceFlowers(int[], int)
     * @see Solution601#predictPartyVictory(String)
     * @see <a href="https://leetcode-cn.com/problems/teemo-attacking/">Teemo Attacking</a>
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int lastEnd = 0, notPoisoned = 0;
        for (int time : timeSeries) {
            if (time > lastEnd) {
                notPoisoned += time - lastEnd;
            }
            lastEnd = time + duration;
        }
        return timeSeries[timeSeries.length - 1] + duration - notPoisoned;
    }

    /**
     * 496. Next Greater Element I (Easy)
     *
     * @see Solution501#nextGreaterElements(int[])
     * @see Solution501#nextGreaterElement(int)
     * @see Solution701#dailyTemperatures(int[])
     * @see <a href="https://leetcode-cn.com/problems/next-greater-element-i/">Next Greater Element
     * I</a>
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElements = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (top > num) {
                    break;
                } else {
                    nextGreaterElements.put(top, num);
                }
                stack.pop();
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            res[i] = nextGreaterElements.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    /**
     * 500. Keyboard Row (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/keyboard-row/">Keyboard Row</a>
     */
    public String[] findWords(String[] words) {
        int[] rows = new int[26];
        for (char c : new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'}) {
            rows[c - 'a'] = 1;
        }
        for (char c : new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'}) {
            rows[c - 'a'] = 2;
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isSameRow(word, rows)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean isSameRow(String word, int[] rows) {
        char[] chars = word.toCharArray();
        int row = rows[chars[0] > 'Z' ? (chars[0] - 'a') : chars[0] - 'A'];
        for (int i = chars.length - 1; i > 0; i--) {
            char ch = chars[i];
            if (rows[ch > 'Z' ? ch - 'a' : ch - 'A'] != row) {
                return false;
            }
        }
        return true;
    }
}