package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Solutions to problems No.1-No.100.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution1 extends Solution {

    private final char[][] dict = new char[][]{
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    /**
     * 1. Two Sum (Easy)
     *
     * @see #TIME_N_LOG_N
     * @see #SPACE_N
     * @see Solution1#threeSum(int[])
     * @see Solution1#fourSum(int[], int)
     * @see Solution101#twoSumII(int[], int)
     * @see Solution501#subarraySum(int[], int)
     * @see Solution601#findTarget(TreeNode, int)
     * @see Solution1001#twoSumLessThanK(int[], int)
     * @see Solution1601#maxOperations(int[], int)
     * @see Solution1701#countPairs(int[])
     * @see <a href="https://leetcode-cn.com/problems/two-sum/">Two Sum</a>
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            int other = target - num;
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(num, i);
        }
        throw new IllegalArgumentException("no such two numbers.");
    }

    /**
     * 2. Add Two Numbers (Medium)
     *
     * @see #TIME_M_PLUS_N
     * @see #SPACE_CONSTANT
     * @see Solution1#multiply(String, String)
     * @see Solution1#addBinary(String, String)
     * @see Solution301#getSum(int, int)
     * @see Solution401#addStrings(String, String)
     * @see Solution401#addTwoNumbers(ListNode, ListNode)
     * @see Solution901#addToArrayForm(int[], int)
     * @see Solution1601#addPoly(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">Add Two Numbers</a>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        int carry = 0;
        ListNode added = res;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
            added.next = new ListNode(sum % 10);
            added = added.next;
        }
        while (l1 != null) {
            int sum = l1.val + +carry;
            l1 = l1.next;
            carry = sum / 10;
            added.next = new ListNode(sum % 10);
            added = added.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            l2 = l2.next;
            carry = sum / 10;
            added.next = new ListNode(sum % 10);
            added = added.next;
        }
        if (carry == 1) {
            added.next = new ListNode(1);
        }
        return res.next;
    }

    /**
     * 3. Longest Substring Without Repeating Characters (Medium)
     *
     * @see Solution101#lengthOfLongestSubstringTwoDistinct(String)
     * @see Solution301#lengthOfLongestSubstringKDistinct(String, int)
     * @see Solution901#subarraysWithKDistinct(int[], int)
     * @see Solution1601#maximumUniqueSubarray(int[])
     * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">Longest
     * Substring Without Repeating Characters</a>
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int start = 0, max = 0;
        Map<Character, Integer> lastIndices = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            Integer lastIndex = lastIndices.get(ch);
            if (lastIndex != null) {
                if (lastIndex >= start) {
                    max = Math.max(max, i - start);
                    start = lastIndex + 1;
                }
            }
            lastIndices.put(ch, i);
        }
        max = Math.max(max, len - start);
        return max;
    }

    /**
     * 4. Median of Two Sorted Arrays (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two
     * Sorted Arrays</a>
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // todo
        return 0.0;
    }

    /**
     * 5. Longest Palindromic Substring (Medium)
     * <p>
     * Manacher Algorithm
     *
     * @see Solution201#shortestPalindrome(String)
     * @see Solution201#canPermutePalindrome(String)
     * @see Solution301#palindromePairs(String[])
     * @see Solution501#longestPalindromeSubseq(String)
     * @see Solution601#countSubstrings(String)
     * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">Longest
     * Palindromic Substring</a>
     * @see <a href="https://writings.sh/post/algorithm-longest-palindromic-substring">Four methods
     * for LPS</a>
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int length = len * 2 + 1;
        char[] arr = new char[length];
        for (int i = 0; i < len; i++) {
            arr[2 * i] = '#';
            arr[2 * i + 1] = s.charAt(i);
        }
        arr[length - 1] = '#';
        // the radius of the lps that centres around arr[i]
        int[] radii = new int[length];
        // rmlps: the rightmost of all calculated lps
        // rm: the rightmost index of rmlps, rmc: the center index of rmlps
        int rm = -1, rmc = -1;
        for (int i = 1; i < length; i++) {
            int left = i - 1, right = i + 1;
            if (i < rm) {
                // If arr[i] is within rmlps, find the symmetry point arr[j] against arr[i] in rmlps.
                int j = rmc * 2 - i;
                // If the lps around arr[j] is totally within rmlps, the lps around arr[i] is
                // totally within rmlp too. So radii[i] = radii[j].
                if (radii[j] < rm - i) {
                    radii[i] = radii[j];
                    continue;
                }
                // If beyond, the part arr[2i-rm, rm] is palindrome by symmetry. So the part is
                // unnecessary to be calculated repeatedly.
                left = 2 * i - rm - 1;
                right = rm + 1;
            }
            // Then calculate the part beyond rmlps and update rmlps
            while (left >= 0 && right < length && arr[left] == arr[right]) {
                left--;
                right++;
            }
            radii[i] = right - i - 1;
            if (right > rm) {
                rm = right - 1;
                rmc = i;
            }
        }
        int max = 0, idx = 0;
        for (int i = 0; i < length; i++) {
            if (radii[i] > max) {
                max = radii[i];
                idx = i;
            }
        }
        StringBuilder builder = new StringBuilder(max);
        for (int i = idx - max + 1, j = idx + max; i < j; i += 2) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }

    /**
     * 6. ZigZag Conversion (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/">ZigZag Conversion</a>
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        // Each 2*numRows-2 as a group
        int step = 2 * numRows - 2;
        // the 1st row, one element each group
        for (int i = 0; i < len; i += step) {
            builder.append(s.charAt(i));
        }
        // the jth row, 0 < j < numRows-1, two elements each group
        for (int j = 1, end = numRows - 1; j < end; j++) {
            // the difference between the two elements
            int dif = 2 * (numRows - 1 - j);
            for (int i = j; i < len; i += step) {
                builder.append(s.charAt(i));
                int second = i + dif;
                if (second < len) {
                    builder.append(s.charAt(second));
                }
            }
        }
        // the last row
        for (int i = numRows - 1; i < len; i += step) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    /**
     * 7. Reverse Integer (Easy)
     *
     * @see Integer#parseInt(String, int)
     * @see Solution1#myAtoi(String)
     * @see Solution101#reverseBits(int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">Reverse Integer</a>
     */
    public int reverse(int x) {
        // todo
        return 0;
    }

    /**
     * 8. String to Integer (atoi) (Medium)
     *
     * @see Solution1#reverse(int)
     * @see Solution1#isNumber(String)
     * @see <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">String to Integer
     * (atoi)</a>
     */
    public int myAtoi(String s) {
        int i = 0, len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        char first = s.charAt(i);
        boolean positive = true;
        if (first == '+' || first == '-') {
            positive = first == '+';
            i++;
        }
        int limit = positive ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
        int mulLimit = limit / 10;
        int value = 0;
        // handle as negative
        while (i < len) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (value < mulLimit) {
                // exceed
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value *= 10;
            if (value < limit + digit) {
                // exceed
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value -= digit;
            i++;
        }
        return positive ? -value : value;
    }

    /**
     * 9. Palindrome Number (Easy)
     *
     * @see Solution201#isPalindrome(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">Palindrome Number</a>
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        do {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        } while (x > reversed);
        return x == reversed || x == reversed / 10;
    }

    /**
     * 10. Regular Expression Matching (Hard)
     *
     * @see Solution1#isMatch(String, String)
     * @see <a href="https://leetcode-cn.com/problems/regular-expression-matching/">Regular
     * Expression Matching</a>
     */
    public boolean isMatch(String s, String p) {
        // todo
        return false;
    }

    /**
     * 11. Container With Most Water (Medium)
     *
     * @see Solution1#trap(int[])
     * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Container With
     * Most Water</a>
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            int hl = height[left], hr = height[right];
            if (hl < hr) {
                // find next element higher than hl and calculate the area with hr
                do {
                    left++;
                } while (left < right && height[left] <= hl);
                max = Math.max(Math.min(height[left], hr) * (right - left), max);
            } else {
                // find next element higher than hr and calculate the area with hl
                do {
                    right--;
                } while (left < right && height[right] <= hr);
                max = Math.max(Math.min(hl, height[right]) * (right - left), max);
            }
        }
        return max;
    }

    /**
     * 12. Integer to Roman (Medium)
     *
     * @see Solution1#romanToInt(String)
     * @see Solution201#numberToWords(int)
     * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">Integer to Roman</a>
     */
    public String intToRoman(int num) {
        char[] dict = new char[]{
            'I', 'V', 'X', 'L', 'C', 'D', 'M'
        };
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit < 4) {
                while (digit-- > 0) {
                    builder.append(dict[i]);
                }
            } else if (digit == 4) {
                builder.append(dict[i + 1]).append(dict[i]);
            } else if (digit < 9) {
                while (digit-- > 5) {
                    builder.append(dict[i]);
                }
                builder.append(dict[i + 1]);
            } else {
                builder.append(dict[i + 2]).append(dict[i]);
            }
            num /= 10;
            i += 2;
        }
        return builder.reverse().toString();
    }

    /**
     * 13. Roman to Integer (Easy)
     *
     * @see Solution1#intToRoman(int)
     * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">Roman to Integer</a>
     */
    public int romanToInt(String s) {
        Map<Character, Integer> symbols = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        char[] chars = s.toCharArray();
        int ret = 0;
        int last = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];
            int value = symbols.get(ch);
            if (value < last) {
                ret -= value;
            } else {
                ret += value;
            }
            last = value;
        }
        return ret;
    }

    /**
     * 14. Longest Common Prefix (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">Longest Common
     * Prefix</a>
     */
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        String first = strs[0];
        for (int ci = 0; ci < first.length(); ci++) {
            char fch = first.charAt(ci);
            for (int si = 1; si < length; si++) {
                String str = strs[si];
                if (ci >= str.length()) {
                    return first.substring(0, ci);
                }
                char ch = str.charAt(ci);
                if (ch != fch) {
                    return first.substring(0, ci);
                }
            }
        }
        return first;
    }

    /**
     * 14.2 Longest Common Prefix (Easy) (Sort and then compare the first and the last)
     */
    public String longestCommonPrefix2(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        while (index < first.length() && index < last.length() && first.charAt(index) == last
            .charAt(index)) {
            index++;
        }
        return first.substring(0, index);
    }

    /**
     * 15. 3Sum (Medium)
     *
     * @see Solution1#twoSum(int[], int)
     * @see Solution1#threeSumClosest(int[], int)
     * @see Solution1#fourSum(int[], int)
     * @see Solution201#threeSumSmaller(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/3sum/">3Sum</a>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int av = nums[0] - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0, aLen = len - 2; a < aLen; a++) {
            if (av == nums[a]) {
                continue;
            }
            // if always larger than the target
            if (nums[a] + nums[a + 1] + nums[a + 2] > 0) {
                continue;
            }
            // if always smaller than the target
            if (nums[a] + nums[len - 2] + nums[len - 1] < 0) {
                continue;
            }
            av = nums[a];
            int left = a + 1, right = len - 1;
            while (left < right) {
                int sum = av + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    int bv = nums[left], cv = nums[right];
                    res.add(Arrays.asList(av, bv, cv));
                    // find different ones
                    do {
                        left++;
                    } while (left < right && nums[left] == bv);
                    do {
                        right--;
                    } while (left < right && nums[right] == cv);
                }
            }
        }
        return res;
    }

    /**
     * 16. 3Sum Closest (Medium)
     *
     * @see Solution1#threeSum(int[])
     * @see Solution201#threeSumSmaller(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/3sum-closest/">3Sum Closest</a>
     */
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int a = nums[0] - 1;
        int minDif = Integer.MAX_VALUE;
        boolean larger = false;
        for (int i = 0, max = len - 2; i < max; i++) {
            if (a == nums[i]) {
                continue;
            }
            a = nums[i];
            int bc = target - a;
            // find the closest
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < bc) {
                    int dif = bc - sum;
                    if (dif < minDif) {
                        minDif = dif;
                        larger = false;
                    }
                    left++;
                } else if (sum > bc) {
                    int dif = sum - bc;
                    if (dif < minDif) {
                        minDif = dif;
                        larger = true;
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }
        return larger ? target + minDif : target - minDif;
    }

    /**
     * 17. Letter Combinations of a Phone Number (Medium)
     *
     * @see Solution1#generateParenthesis(int)
     * @see Solution1#combinationSum(int[], int)
     * @see Solution401#readBinaryWatch(int)
     * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">Letter
     * Combinations of a Phone Number</a>
     */
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) {
            return new ArrayList<>();
        }
        List<String> res = List.of("");
        for (int i = 0; i < len; i++) {
            char[] chars = dict[digits.charAt(i) - '2'];
            List<String> cur = new ArrayList<>(res.size() * chars.length);
            for (char ch : chars) {
                for (String pre : res) {
                    cur.add(pre + ch);
                }
            }
            res = cur;
        }
        return res;
    }

    /**
     * 18. 4Sum (Medium)
     *
     * @see Solution1#twoSum(int[], int)
     * @see Solution1#threeSum(int[])
     * @see Solution401#fourSumCount(int[], int[], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/4sum/">4Sum</a>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int av = nums[0] - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0, aLen = len - 3; a < aLen; a++) {
            if (av == nums[a]) {
                continue;
            }
            // if always larger than the target
            if (nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                continue;
            }
            // if always smaller than the target
            if (nums[a] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            av = nums[a];
            int bcd = target - av;
            int bv = av - 1;
            for (int b = a + 1, bLen = len - 2; b < bLen; b++) {
                if (bv == nums[b]) {
                    continue;
                }
                // if always larger than the target
                if (nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    continue;
                }
                // if always smaller than the target
                if (nums[a] + nums[b] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                bv = nums[b];
                int cd = bcd - bv;
                int c = b + 1, d = len - 1;
                while (c < d) {
                    int sum = nums[c] + nums[d];
                    if (sum > cd) {
                        d--;
                    } else if (sum < cd) {
                        c++;
                    } else {
                        int cv = nums[c], dv = nums[d];
                        res.add(Arrays.asList(av, bv, cv, dv));
                        // find different ones
                        do {
                            c++;
                        } while (c < d && nums[c] == cv);
                        do {
                            d--;
                        } while (c < d && nums[d] == dv);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 19. Remove Nth Node From End of List (Medium)
     *
     * @see Solution1701#swapNodes(ListNode, int)
     * @see Solution1401#deleteNodes(ListNode, int, int)
     * @see <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">Remove Nth
     * Node From End of List</a>
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // faster node is n steps faster than the slower one
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            assert head != null;
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 20. Valid Parentheses (Easy)
     *
     * @see Solution1#generateParenthesis(int)
     * @see Solution1#longestValidParentheses(String)
     * @see Solution301#removeInvalidParentheses(String)
     * @see Solution1001#isValid(String)
     * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">Valid Parentheses</a>
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ('(' == ch || '[' == ch || '{' == ch) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            int match = ch - stack.pop();
            if (match == 1 || match == 2) {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    /**
     * 21. Merge Two Sorted Lists (Easy)
     *
     * @see Solution1#mergeKLists(ListNode[])
     * @see Solution1#merge(int[], int, int[], int)
     * @see Solution101#sortList(ListNode)
     * @see Solution1601#addPoly(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">Merge Two Sorted
     * Lists</a>
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1, cursor2 = l2;
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        while (cursor1 != null && cursor2 != null) {
            if (cursor1.val < cursor2.val) {
                cursor.next = new ListNode(cursor1.val);
                cursor1 = cursor1.next;
            } else {
                cursor.next = new ListNode(cursor2.val);
                cursor2 = cursor2.next;
            }
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
        return result.next;
    }

    /**
     * 22. Generate Parentheses (Medium)
     *
     * @see Solution1#letterCombinations(String)
     * @see Solution1#isValid(String)
     * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">Generate
     * Parentheses</a>
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", n, 0, 0);
        return res;
    }

    /**
     * @param p     current parenthesis
     * @param left  the count of '(' in p
     * @param right the count of ')' in p
     */
    private void generateParenthesis(List<String> res, String p, int n, int left, int right) {
        if (left < right) {
            return;
        }
        if (left > n) {
            return;
        }
        if (right == n) {
            res.add(p);
        }
        generateParenthesis(res, p + "(", n, left + 1, right);
        generateParenthesis(res, p + ")", n, left, right + 1);
    }

    /**
     * 23. Merge k Sorted Lists (Hard)
     *
     * @see Solution1#mergeTwoLists(ListNode, ListNode)
     * @see Solution201#nthUglyNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">Merge k Sorted
     * Lists</a>
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // todo
        return new ListNode();
    }

    /**
     * 24. Swap Nodes in Pairs (Medium)
     *
     * @see Solution1#reverseKGroup(ListNode, int)
     * @see Solution1701#swapNodes(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
     */
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        while (node.next != null && node.next.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            node = node.next;
            next.next = node.next;
            node.next = next;
            node = node.next;
        }
        return res.next;
    }

    /**
     * 25. Reverse Nodes in k-Group (Hard)
     *
     * @see Solution1#swapPairs(ListNode)
     * @see Solution1701#swapNodes(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in
     * k-Group</a>
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // todo
        return new ListNode();
    }

    /**
     * 26. Remove Duplicates from Sorted Array (Easy)
     *
     * @see Solution1#removeElement(int[], int)
     * @see Solution1#removeDuplicates(int[])
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">Remove
     * Duplicates from Sorted Array</a>
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    /**
     * 27. Remove Element (Easy)
     *
     * @see Solution1#removeDuplicates(int[])
     * @see Solution201#removeElements(ListNode, int)
     * @see Solution201#moveZeroes(int[])
     * @see <a href="https://leetcode-cn.com/problems/remove-element/">Remove Element</a>
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /**
     * 28. Implement strStr() (Easy)
     *
     * @see String#indexOf(String)
     * @see Solution201#shortestPalindrome(String)
     * @see Solution401#repeatedSubstringPattern(String)
     * @see <a href="https://leetcode-cn.com/problems/implement-strstr/">Implement strStr()</a>
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 29. Divide Two Integers (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/divide-two-integers/">Divide Two Integers</a>
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("divided by zero");
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean negative = (dividend ^ divisor) < 0;
        divisor = (divisor >= 0) ? divisor : -divisor;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            int quotient = dividePositive(-(dividend + divisor), divisor) + 1;
            return negative ? -quotient : quotient;
        }
        dividend = (dividend >= 0) ? dividend : -dividend;
        int quotient = dividePositive(dividend, divisor);
        return negative ? -quotient : quotient;
    }

    private int dividePositive(int dividend, int divisor) {
        // both the dividend and divisor are positive
        int res = 0;
        int bits = 0x4000_0000, temp = 0;
        while (bits > 0) {
            // top digit
            int top = (dividend & bits) == 0 ? 0 : 1;
            temp = (temp << 1) | top;
            bits >>= 1;
            if (temp >= divisor) {
                // the first x digits that larger than (or equal to) divisor
                // then add 1 to the corresponding digit of the quotient
                temp -= divisor;
                res = (res << 1) | 1;
            } else {
                res = res << 1;
            }
        }
        return res;
    }

    /**
     * 30. Substring with Concatenation of All Words (Hard)
     *
     * @see Solution1#minWindow(String, String)
     * @see <a href="https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/">Substring
     * with Concatenation of All Words</a>
     */
    public int[] findSubstring(String s, String[] words) {
        // todo
        return new int[0];
    }

    /**
     * 31. Next Permutation (Medium)
     *
     * @see Solution1#permute(int[])
     * @see Solution1#permuteUnique(int[])
     * @see Solution1#getPermutation(int, int)
     * @see Solution201#generatePalindromes(String)
     * @see Solution1801#getMinSwaps(String, int)
     * @see <a href="https://leetcode-cn.com/problems/next-permutation/">Next Permutation</a>
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int i = len - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        // rearrange nums[i, len) from decreasing to increasing
        for (int left = i, right = len - 1; left < right; left++, right--) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        if (i > 0) {
            // find the num to be swapped with nums[i-1] and swap
            int left = i, right = len - 1, target = nums[i - 1];
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[left];
            nums[left] = temp;
        }
    }

    /**
     * 32. Longest Valid Parentheses (Hard)
     *
     * @see Solution1#isValid(String)
     * @see <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">Longest Valid
     * Parentheses</a>
     */
    public int longestValidParentheses(String s) {
        // todo
        return 0;
    }

    /**
     * 33. Search in Rotated Sorted Array (Medium)
     *
     * @see Solution1#search(int[], int)
     * @see Solution101#findMin(int[])
     * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">Search in
     * Rotated Sorted Array</a>
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 34. Find First and Last Position of Element in Sorted Array (Medium)
     *
     * @see Solution201#firstBadVersion(int)
     * @see <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find
     * First and Last Position of Element in Sorted Array</a>
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int[] res = new int[]{-1, -1};
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }

    /**
     * 35. Search Insert Position (Easy)
     *
     * @see Arrays#binarySearch(int[], int)
     * @see Solution201#firstBadVersion(int)
     * @see <a href="https://leetcode-cn.com/problems/search-insert-position/">Search Insert
     * Position</a>
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    /**
     * 36. Valid Sudoku (Medium)
     *
     * @see Solution1#solveSudoku(char[][])
     * @see <a href="https://leetcode-cn.com/problems/valid-sudoku/">Valid Sudoku</a>
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[] stat = new boolean[10];
        // rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int idx = ch - '0';
                    if (stat[idx]) {
                        return false;
                    }
                    stat[idx] = true;
                }
            }
            Arrays.fill(stat, false);
        }
        // columns
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int idx = ch - '0';
                    if (stat[idx]) {
                        return false;
                    }
                    stat[idx] = true;
                }
            }
            Arrays.fill(stat, false);
        }
        // sub-boxes
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                int xm = x + 3, ym = y + 3;
                for (int i = x; i < xm; i++) {
                    for (int j = y; j < ym; j++) {
                        char ch = board[i][j];
                        if (ch != '.') {
                            int idx = ch - '0';
                            if (stat[idx]) {
                                return false;
                            }
                            stat[idx] = true;
                        }
                    }
                }
                Arrays.fill(stat, false);
            }
        }
        return true;
    }

    /**
     * 37. Sudoku Solver (Hard)
     *
     * @see Solution1#isValidSudoku(char[][])
     * @see Solution901#uniquePathsIII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/sudoku-solver/">Sudoku Solver</a>
     */
    public void solveSudoku(char[][] board) {
        // todo
    }

    /**
     * 38. Count and Say (Medium)
     *
     * @see Solution201#encode(String[])
     * @see Solution401#compress(char[])
     * @see <a href="https://leetcode-cn.com/problems/count-and-say/">Count and Say</a>
     */
    public String countAndSay(int n) {
        String res = "1";
        while (n-- > 1) {
            StringBuilder builder = new StringBuilder();
            char current = res.charAt(0);
            int count = 1, len = res.length();
            for (int i = 1; i < len; i++) {
                char ch = res.charAt(i);
                if (ch != current) {
                    builder.append(count).append(current);
                    current = ch;
                    count = 1;
                } else {
                    count++;
                }
            }
            builder.append(count).append(current);
            res = builder.toString();
        }
        return res;
    }

    /**
     * 39. Combination Sum (Medium)
     *
     * @see Solution1#letterCombinations(String)
     * @see Solution1#combinationSum2(int[], int)
     * @see Solution1#combine(int, int)
     * @see Solution201#combinationSum3(int, int)
     * @see Solution201#getFactors(int)
     * @see Solution301#combinationSum4(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/combination-sum/">Combination Sum</a>
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    /**
     * @param res    the whole result
     * @param chosen list of all chosen elements
     * @param target the left target after subtracting the elements chosen in {@code chosen}
     * @param start  the start index of left elements to be chosen
     */
    private void combinationSum(int[] candidates, List<List<Integer>> res, List<Integer> chosen,
        int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                // since the array is sorted, the left elements are ignored
                break;
            }
            chosen.add(candidates[i]);
            combinationSum(candidates, res, chosen, target - candidates[i], i);
            chosen.remove(chosen.size() - 1);
        }
    }

    /**
     * 40. Combination Sum II (Medium)
     *
     * @see Solution1#combinationSum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/combination-sum-ii/">Combination Sum II</a>
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int current = candidates[0], count = 1, len = 0;
        int[] counts = new int[candidates.length];
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] == current) {
                count++;
            } else {
                candidates[len] = current;
                counts[len] = count;
                current = candidates[i];
                count = 1;
                len++;
            }
        }
        candidates[len] = current;
        counts[len] = count;
        len++;
        List<List<Integer>> res = new ArrayList<>();
        combinationSum2(candidates, counts, len, res, new ArrayList<>(), target, 0, 0);
        return res;
    }

    /**
     * @param candidates the distinct candidates
     * @param counts     the count of each candidate
     * @param len        the number of distinct candidates
     * @param res        the whole result
     * @param chosen     list of all chosen elements
     * @param target     the left target after subtracting the elements chosen in {@code chosen}
     * @param start      the start index of left elements to be chosen
     * @param count      the count of the element at start index contained in {@code chosen}
     */
    private void combinationSum2(int[] candidates, int[] counts, int len, List<List<Integer>> res,
        List<Integer> chosen, int target, int start, int count) {
        if (target == 0) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        // choose the element at start index
        if (target < candidates[start]) {
            return;
        }
        if (count < counts[start]) {
            chosen.add(candidates[start]);
            int tgt = target - candidates[start];
            combinationSum2(candidates, counts, len, res, chosen, tgt, start, count + 1);
            chosen.remove(chosen.size() - 1);
        }
        // choose elements after start index
        for (int i = start + 1; i < len; i++) {
            if (target < candidates[i]) {
                // since the array is sorted, the left elements are ignored
                return;
            }
            chosen.add(candidates[i]);
            combinationSum2(candidates, counts, len, res, chosen, target - candidates[i], i, 1);
            chosen.remove(chosen.size() - 1);
        }
    }

    /**
     * 41. First Missing Positive (Hard)
     *
     * @see Solution201#missingNumber(int[])
     * @see Solution201#findDuplicate(int[])
     * @see Solution401#findDisappearedNumbers(int[])
     * @see Solution701#minSwapsCouples(int[])
     * @see <a href="https://leetcode-cn.com/problems/first-missing-positive/">First Missing
     * Positive</a>
     */
    public int firstMissingPositive(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 42. Trapping Rain Water (Hard)
     *
     * @see Solution1#maxArea(int[])
     * @see Solution201#productExceptSelf(int[])
     * @see Solution401#trapRainWater(int[][])
     * @see Solution701#pourWater(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/trapping-rain-water/">Trapping Rain Water</a>
     */
    public int trap(int[] height) {
        // todo
        return 0;
    }

    /**
     * 43. Multiply Strings (Medium)
     *
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1#plusOne(int[])
     * @see Solution1#addBinary(String, String)
     * @see Solution401#addStrings(String, String)
     * @see <a href="https://leetcode-cn.com/problems/multiply-strings/">Multiply Strings</a>
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // the carry of last digit
        int carry = 0, len1 = num1.length(), len2 = num2.length();
        StringBuilder res = new StringBuilder(len1 + len2);
        // k: the sum of the indices of the two chosen digits
        for (int k = len1 + len2 - 2; k >= 0; k--) {
            int i = Math.max(0, k - len2 + 1);
            int iLen = Math.min(k + 1, len1);
            for (int j = k - i; i < iLen; i++, j--) {
                carry += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
            res.append(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }

    /**
     * 43.2 Multiply Strings (Medium)
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] digits = new int[len1 + len2 - 1];
        // multiply the two digits respectively and sum to the corresponding position
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                digits[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        StringBuilder res = new StringBuilder(len1 + len2);
        // sum up all result backwards
        for (int k = digits.length - 1; k >= 0; k--) {
            carry += digits[k];
            res.append(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }

    /**
     * 44. Wildcard Matching (Hard)
     *
     * @see Solution1#isMatch(String, String)
     * @see <a href="https://leetcode-cn.com/problems/wildcard-matching/">Wildcard Matching</a>
     */
    public boolean isMatchII(String s, String p) {
        // todo
        return false;
    }

    /**
     * 45. Jump Game II (Medium)
     *
     * @see Solution1#canJump(int[])
     * @see Solution1301#canReach(int[], int)
     * @see Solution1801#canReach(String, int, int)
     * @see <a href="https://leetcode-cn.com/problems/jump-game-ii/">Jump Game II</a>
     */
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        // rm: the rightmost position that can be reached after 'step' steps
        // nrm: the next 'rm'
        int step = 0, rm = 0, nrm = nums[0], target = len - 1;
        for (int i = 1; i < len; i++) {
            if (nrm >= target) {
                return step + 1;
            }
            if (i > rm) {
                step++;
                rm = nrm;
            }
            nrm = Math.max(nrm, i + nums[i]);
        }
        throw new IllegalArgumentException("Can't reach the end of the array");
    }

    /**
     * 46. Permutations (Medium)
     *
     * @see Solution1#nextPermutation(int[])
     * @see Solution1#permuteUnique(int[])
     * @see Solution1#getPermutation(int, int)
     * @see Solution1#combine(int, int)
     * @see <a href="https://leetcode-cn.com/problems/permutations/">Permutations</a>
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList<>(nums.length), new boolean[nums.length]);
        return res;
    }

    /**
     * @param temp    store visited numbers
     * @param visited if a number is visited
     */
    private void permute(int[] nums, List<List<Integer>> res, List<Integer> temp,
        boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                permute(nums, res, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 47. Permutations II (Medium)
     *
     * @see Solution1#nextPermutation(int[])
     * @see Solution1#permute(int[])
     * @see Solution201#generatePalindromes(String)
     * @see Solution901#numSquarefulPerms(int[])
     * @see <a href="https://leetcode-cn.com/problems/permutations-ii/">Permutations II</a>
     */
    public int[][] permuteUnique(int[] nums) {
        // todo
        return new int[0][0];
    }

    /**
     * 48. Rotate Image (Medium)
     *
     * @see Solution1801#findRotation(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/rotate-image/">Rotate Image</a>
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = len - 1;
        // rotate quarter of the matrix four times
        for (int i = 0, iLen = (len + 1) / 2; i < iLen; i++) {
            for (int j = 0, jLen = len / 2; j < jLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }

    /**
     * 50. Pow(x, n) (Medium)
     *
     * @see Math#pow(double, double)
     * @see Solution1#mySqrt(int)
     * @see Solution301#superPow(int, int[])
     * @see <a href="https://leetcode-cn.com/problems/powx-n/">Pow(x, n)</a>
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            if (n == 1) {
                return x;
            }
            double res = myPow(x, n >> 1);
            return res * res * (n % 2 == 0 ? 1 : x);
        } else {
            return 1 / myPow(x, -(n + 1)) / x;
        }
    }

    /**
     * 51. N-Queens (Hard)
     *
     * @see Solution1#totalNQueens(int)
     * @see Solution1001#gridIllumination(int, int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/n-queens/">N-Queens</a>
     */
    public String[][] solveNQueens(int n) {
        // todo
        return new String[0][0];
    }

    /**
     * 52. N-Queens II (Hard)
     *
     * @see Solution1#solveNQueens(int)
     * @see <a href="https://leetcode-cn.com/problems/n-queens-ii/">N-Queens II</a>
     */
    public int totalNQueens(int n) {
        // todo
        return 0;
    }

    /**
     * 53. Maximum Subarray (Easy)
     * <p>
     * By divide and conquer: Assumes that sum[i] is the maxSubSeqSum of arrays that end with
     * nums[i], then
     * <span>sum[i+1] = max{sum[i] + nums[i+1], nums[i+1]}</span>
     * <span>res[i+1] = max{res[i], sum[i+1]}</span>
     *
     * @see #TIME_N
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProduct(int[])
     * @see Solution601#findShortestSubArray(int[])
     * @see Solution901#maxTurbulenceSize(int[])
     * @see Solution1701#maxAbsoluteSum(int[])
     * @see Solution1701#maxSumAfterOperation(int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">Maximum Subarray</a>
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }

    /**
     * 54. Spiral Matrix (Medium)
     *
     * @see Solution1#generateMatrix(int)
     * @see Solution801#spiralMatrixIII(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/spiral-matrix/">Spiral Matrix</a>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = -1, di = 0, dj = 1, len = n, turns = 0;
        do {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                res.add(matrix[i][j]);
            }
            turns++;
            // turn right when reaching the end in this direction
            int temp = di;
            di = dj;
            dj = -temp;
            len = (m + n) - len - turns;
        } while (len > 0);
        return res;
    }

    /**
     * 55. Jump Game (Medium)
     *
     * @see Solution1#jump(int[])
     * @see Solution1301#canReach(int[], int)
     * @see Solution1801#canReach(String, int, int)
     * @see <a href="https://leetcode-cn.com/problems/jump-game/">Jump Game</a>
     */
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        while (target > 0) {
            // if the target is reachable
            boolean reachable = false;
            for (int i = target - 1; i >= 0; i--) {
                if (i + nums[i] >= target) {
                    target = i;
                    reachable = true;
                    break;
                }
            }
            if (!reachable) {
                return false;
            }
        }
        return true;
    }

    /**
     * 56. Merge Intervals (Medium)
     *
     * @see Solution1#insert(int[][], int[])
     * @see Solution201#canAttendMeetings(int[][])
     * @see Solution201#minMeetingRooms(int[][])
     * @see Solution401#findPoisonedDuration(int[], int)
     * @see Solution601#addBoldTag(String, String[])
     * @see Solution701#employeeFreeTime(int)
     * @see Solution701#partitionLabels(String)
     * @see Solution901#intervalIntersection(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/merge-intervals/">Merge Intervals</a>
     */
    public int[][] merge(int[][] intervals) {
        // sort by start times
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // merge if overlapping
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
                last = cur;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    /**
     * 57. Insert Interval (Medium)
     *
     * @see Solution1#merge(int[][])
     * @see <a href="https://leetcode-cn.com/problems/insert-interval/">Insert Interval</a>
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int i = Arrays.binarySearch(intervals, newInterval, Comparator.comparingInt(o -> o[0]));
        if (i < 0) {
            i = i == -1 ? 0 : -(i + 1) - 1;
        }
        // merge since i
        while (i < len) {
            int[] interval = intervals[i];
            if (newInterval[1] <= interval[1]) {
                // not exceed current interval
                if (newInterval[1] >= interval[0]) {
                    // merge if overlapping
                    interval[0] = Math.min(interval[0], newInterval[0]);
                    return intervals;
                } else {
                    // insert at the i
                    int[][] res = new int[len + 1][2];
                    System.arraycopy(intervals, 0, res, 0, i);
                    res[i] = newInterval;
                    System.arraycopy(intervals, i, res, i + 1, len - i);
                    return res;
                }
            }
            if (newInterval[0] > interval[1]) {
                // not overlapping
                i++;
            } else {
                // extend the end time if overlapping
                interval[0] = Math.min(interval[0], newInterval[0]);
                int end = newInterval[1];
                int j = i + 1;
                while (j < len) {
                    if (end < intervals[j][0]) {
                        break;
                    } else if (end <= intervals[j][1]) {
                        end = intervals[j][1];
                        j++;
                        break;
                    } else {
                        j++;
                    }
                }
                interval[1] = end;
                i++;
                // merge intervals[0,i) and intervals[j,len)
                if (i == j) {
                    return intervals;
                }
                int[][] res = new int[i + len - j][2];
                System.arraycopy(intervals, 0, res, 0, i);
                System.arraycopy(intervals, j, res, i, len - j);
                return res;
            }
        }
        // append at the last of the intervals
        int[][] res = Arrays.copyOf(intervals, len + 1);
        res[len] = newInterval;
        return res;
    }

    /**
     * 58. Length of Last Word (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/">Length of Last Word</a>
     */
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        if (right < 0) {
            return 0;
        }
        int left = right - 1;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }

    /**
     * 59. Spiral Matrix II (Medium)
     *
     * @see Solution1#spiralOrder(int[][])
     * @see Solution801#spiralMatrixIII(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">Spiral Matrix II</a>
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = -1, di = 0, dj = 1, len = n, turns = 0, value = 1;
        do {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                res[i][j] = value++;
            }
            turns++;
            // turn right when reaching the end in this direction
            int temp = di;
            di = dj;
            dj = -temp;
            len = (n + n) - len - turns;
        } while (len > 0);
        return res;
    }

    /**
     * 60. Permutation Sequence (Hard)
     *
     * @see Solution1#nextPermutation(int[])
     * @see Solution1#permute(int[])
     * @see <a href="https://leetcode-cn.com/problems/permutation-sequence/">Permutation
     * Sequence</a>
     */
    public String getPermutation(int n, int k) {
        // todo
        return "";
    }

    /**
     * 61. Rotate List (Medium)
     *
     * @see Solution101#rotate(int[], int)
     * @see Solution1#removeNthFromEnd(ListNode, int)
     * @see Solution701#splitListToParts(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/rotate-list/">Rotate List</a>
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = size - k % size;
        // concat the head and tail as a circle
        tail.next = head;
        while (k-- > 0) {
            tail = head;
            head = head.next;
        }
        // cut at kth node
        tail.next = null;
        return head;
    }

    /**
     * 62. Unique Paths (Medium)
     *
     * @see Solution1#uniquePathsWithObstacles(int[][])
     * @see Solution1#minPathSum(int[][])
     * @see Solution101#calculateMinimumHP(int[][])
     * @see <a href="https://leetcode-cn.com/problems/unique-paths/">Unique Paths</a>
     */
    public int uniquePaths(int m, int n) {
        // combinatorial number: C(m-1, m+n-2)
        long res = 1;
        int i = Math.min(m, n) - 1, k = m + n - 2;
        for (int j = 0; j < i; j++) {
            res *= k--;
        }
        while (i > 1) {
            res /= i--;
        }
        return (int) res;
    }

    /**
     * 63. Unique Paths II (Medium)
     *
     * @see Solution1#uniquePaths(int, int)
     * @see Solution901#uniquePathsIII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/unique-paths-ii/">Unique Paths II</a>
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                res[i][0] = 0;
            } else {
                res[i][0] = res[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                res[0][j] = 0;
            } else {
                res[0][j] = res[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 64. Minimum Path Sum (Medium)
     *
     * @see Solution1#uniquePaths(int, int)
     * @see Solution1#uniquePathsWithObstacles(int[][])
     * @see Solution101#calculateMinimumHP(int[][])
     * @see Solution701#cherryPickup(int[][])
     * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">Minimum Path Sum</a>
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 65. Valid Number (Hard)
     *
     * @see Solution1#myAtoi(String)
     * @see <a href="https://leetcode-cn.com/problems/valid-number/">Valid Number</a>
     */
    public boolean isNumber(String s) {
        // todo
        return false;
    }

    /**
     * 66. Plus One (Easy)
     *
     * @see Solution1#multiply(String, String)
     * @see Solution1#addBinary(String, String)
     * @see Solution301#plusOne(ListNode)
     * @see Solution901#addToArrayForm(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/plus-one/">Plus One</a>
     */
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; carry && i >= 0; i--) {
            int d = digits[i] + 1;
            if (d == 10) {
                digits[i] = 0;
            } else {
                digits[i] = d;
                carry = false;
            }
        }
        if (!carry) {
            return digits;
        }
        int[] copy = new int[digits.length + 1];
        copy[0] = 1;
        System.arraycopy(digits, 0, copy, 1, digits.length);
        return copy;
    }

    /**
     * 67. Add Binary (Easy)
     *
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1#multiply(String, String)
     * @see Solution1#plusOne(int[])
     * @see Solution401#addStrings(String, String)
     * @see Solution901#addToArrayForm(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/add-binary/">Add Binary</a>
     */
    public String addBinary(String a, String b) {
        int ai = a.length() - 1, bi = b.length() - 1;
        int ri = Math.max(ai, bi) + 1;
        char[] res = new char[ri + 1];
        int carry = 0;
        while (ai >= 0 && bi >= 0) {
            int av = a.charAt(ai--) - '0';
            int bv = b.charAt(bi--) - '0';
            int sum = av + bv + carry;
            res[ri--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        while (carry > 0 && ai >= 0) {
            char ac = a.charAt(ai--);
            if (ac == '0') {
                carry = 0;
                res[ri--] = '1';
            } else {
                res[ri--] = '0';
            }
        }
        while (ai >= 0) {
            res[ri--] = a.charAt(ai--);
        }
        while (carry > 0 && bi >= 0) {
            char bc = b.charAt(bi--);
            if (bc == '0') {
                carry = 0;
                res[ri--] = '1';
            } else {
                res[ri--] = '0';
            }
        }
        while (bi >= 0) {
            res[ri--] = b.charAt(bi--);
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[0] = '1';
        return String.valueOf(res);
    }

    /**
     * 68. Text Justification (Hard)
     *
     * @see Solution1501#reorderSpaces(String)
     * @see <a href="https://leetcode-cn.com/problems/text-justification/">Text Justification</a>
     */
    public String[] fullJustify(String[] words, int maxWidth) {
        // todo
        return new String[0];
    }

    /**
     * 69. Sqrt(x) (Easy)
     *
     * @see Solution1#myPow(double, int)
     * @see Solution301#isPerfectSquare(int)
     * @see <a href="https://leetcode-cn.com/problems/sqrtx/">Sqrt(x)</a>
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left < right) {
            right = left + ((right - left) >> 1);
            left = x / right;
        }
        return right;
    }

    /**
     * 70. Climbing Stairs (Easy)
     * <p>
     * Fibonacci sequence
     *
     * @see Solution701#minCostClimbingStairs(int[])
     * @see Solution501#fib(int)
     * @see Solution1101#tribonacci(int)
     * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">Climbing Stairs</a>
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int lastLast = 1, last = 2;
        for (int i = 3; i <= n; i++) {
            last = lastLast + last;
            lastLast = last - lastLast;
        }
        return last;
    }

    /**
     * 71. Simplify Path (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/simplify-path/">Simplify Path</a>
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (char ch : (path + "/").toCharArray()) {
            if (ch == '/') {
                if (temp.length() > 0) {
                    String name = temp.toString();
                    if ("..".equals(name)) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else if (!".".equals(name)) {
                        stack.push(name);
                    }
                    temp = new StringBuilder();
                }
            } else {
                temp.append(ch);
            }
        }
        if (stack.empty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/").append(s);
        }
        return res.toString();
    }

    /**
     * 72. Edit Distance (Hard)
     *
     * @see Solution101#isOneEditDistance(String, String)
     * @see Solution501#minDistance(String, String)
     * @see Solution701#minimumDeleteSum(String, String)
     * @see Solution1001#maxUncrossedLines(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/edit-distance/">Edit Distance</a>
     */
    public int minDistance(String word1, String word2) {
        // todo
        return 0;
    }

    /**
     * 73. Set Matrix Zeroes (Medium)
     *
     * @see Solution201#gameOfLife(int[][])
     * @see <a href="https://leetcode-cn.com/problems/set-matrix-zeroes/">Set Matrix Zeroes</a>
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, column0 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        for (int[] rows : matrix) {
            if (rows[0] == 0) {
                column0 = true;
                break;
            }
        }
        // record rows and columns to be changed in first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (column0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 74. Search a 2D Matrix (Medium)
     *
     * @see Solution201#searchMatrix(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = matrix[mid][0];
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return right >= 0 && Arrays.binarySearch(matrix[right], target) >= 0;
    }

    /**
     * 75. Sort Colors (Medium)
     *
     * @see Solution101#sortList(ListNode)
     * @see Solution201#wiggleSort(int[])
     * @see Solution301#wiggleSort(int[])
     * @see <a href="https://leetcode-cn.com/problems/sort-colors/">Sort Colors</a>
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 0) {
                left++;
            } else if (nums[right] != 0) {
                right--;
            } else {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
                right--;
            }
        }
        right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 1) {
                left++;
            } else if (nums[right] == 2) {
                right--;
            } else {
                nums[left] = 1;
                nums[right] = 2;
                left++;
                right--;
            }
        }
    }

    /**
     * 76. Minimum Window Substring (Hard)
     *
     * @see Solution1#findSubstring(String, String[])
     * @see Solution201#minSubArrayLen(int, int[])
     * @see Solution201#maxSlidingWindow(int[], int)
     * @see Solution501#checkInclusion(String, String)
     * @see Solution601#smallestRange(int[][])
     * @see Solution701#minWindow(String, String)
     * @see <a href="https://leetcode-cn.com/problems/minimum-window-substring/">Minimum Window
     * Substring</a>
     */
    public String minWindow(String s, String t) {
        // todo
        return "";
    }

    /**
     * 77. Combinations (Medium)
     *
     * @see Solution1#combinationSum(int[], int)
     * @see Solution1#permute(int[])
     * @see <a href="https://leetcode-cn.com/problems/combinations/">Combinations</a>
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(k), 1, n + 1, k);
        return res;
    }

    /**
     * @param temp chosen numbers in ascending order
     * @param from the min number (inclusive) that can be chosen
     * @param to   the max number (exclusive) that can be chosen
     * @param k    the left numbers to choose from [from,to)
     */
    private void combine(List<List<Integer>> res, List<Integer> temp, int from, int to, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = from, len = to - k; i <= len; i++) {
            temp.add(i);
            combine(res, temp, i + 1, to, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 78. Subsets (Medium)
     *
     * @see Solution1#subsetsWithDup(int[])
     * @see Solution301#generateAbbreviations(String)
     * @see Solution701#letterCasePermutation(String)
     * @see <a href="https://leetcode-cn.com/problems/subsets/">Subsets</a>
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, nums, new ArrayList<>(), nums.length - 1);
        return res;
    }

    /**
     * @param temp chosen numbers from [i+1,length)
     * @param i    the index of the number to be chosen or not
     */
    private void subsets(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if (i < 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        subsets(res, nums, temp, i - 1);
        temp.add(nums[i]);
        subsets(res, nums, temp, i - 1);
        temp.remove(temp.size() - 1);
    }

    /**
     * 79. Word Search (Medium)
     *
     * @see Solution201#findWords(char[][], String[])
     * @see <a href="https://leetcode-cn.com/problems/word-search/">Word Search</a>
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length - 1, n = board[0].length - 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (exist(board, m, n, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param m the maximum that i can be
     * @param n the maximum that j can be
     * @param i the row of the char to be compared
     * @param j the column of the char to be compared
     * @param k the index of the char to be found
     */
    private boolean exist(char[][] board, int m, int n, int i, int j, char[] chars, int k) {
        char ch = chars[k];
        if (board[i][j] != ch) {
            return false;
        }
        k++;
        if (k == chars.length) {
            // all found
            return true;
        }
        // used
        board[i][j] = '#';
        if (i > 0 && exist(board, m, n, i - 1, j, chars, k)) {
            return true;
        }
        if (j > 0 && exist(board, m, n, i, j - 1, chars, k)) {
            return true;
        }
        if (i < m && exist(board, m, n, i + 1, j, chars, k)) {
            return true;
        }
        if (j < n && exist(board, m, n, i, j + 1, chars, k)) {
            return true;
        }
        // restore the char
        board[i][j] = ch;
        return false;
    }

    /**
     * 80. Remove Duplicates from Sorted Array II (Medium)
     *
     * @see Solution1#removeDuplicates(int[])
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">Remove
     * Duplicates from Sorted Array II</a>
     */
    public int removeDuplicatesII(int[] nums) {
        int res = 0, cur = nums[0], count = 0;
        for (int num : nums) {
            if (num == cur) {
                count++;
                if (count <= 2) {
                    nums[res++] = cur;
                }
            } else {
                count = 1;
                cur = num;
                nums[res++] = cur;
            }
        }
        return res;
    }

    /**
     * 81. Search in Rotated Sorted Array II (Medium)
     *
     * @see Solution1#search(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">Search in
     * Rotated Sorted Array II</a>
     */
    public boolean searchII(int[] nums, int target) {
        return searchII(nums, 0, nums.length - 1, target);
    }

    private boolean searchII(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal == target) {
                return true;
            }
            if (midVal < nums[high]) {
                if (midVal < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (midVal == nums[high]) {
                if (midVal == nums[low]) {
                    // can't determine the order
                    return searchII(nums, low + 1, mid - 1, target)
                        || searchII(nums, mid + 1, high - 1, target);
                } else {
                    high = mid - 1;
                }
            } else {
                if (midVal > target && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * 82. Remove Duplicates from Sorted List II (Medium)
     *
     * @see Solution1#deleteDuplicates(ListNode)
     * @see Solution1801#deleteDuplicatesUnsorted(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">Remove
     * Duplicates from Sorted List II</a>
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode cur = head, pre = res;
        while (cur != null) {
            ListNode next = cur.next;
            // count of duplicate numbers
            int count = 1, val = cur.val;
            while (next != null && next.val == val) {
                next = next.next;
                count++;
            }
            if (count > 1) {
                // remove all duplicate nodes
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return res.next;
    }

    /**
     * 83. Remove Duplicates from Sorted List (Easy)
     *
     * @see Solution1#deleteDuplicatesII(ListNode)
     * @see Solution1801#deleteDuplicatesUnsorted(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">Remove
     * Duplicates from Sorted List</a>
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head;
        ListNode cursor = head.next;
        while (cursor != null) {
            if (cursor.val == last.val) {
                last.next = cursor.next;
            } else {
                last = cursor;
            }
            cursor = cursor.next;
        }
        return head;
    }

    /**
     * 84. Largest Rectangle in Histogram (Hard)
     *
     * @see Solution1#maximalRectangle(char[][])
     * @see Solution1701#maximumScore(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">Largest
     * Rectangle in Histogram</a>
     */
    public int largestRectangleArea(int[] heights) {
        // todo
        return 0;
    }

    /**
     * 85. Maximal Rectangle (Hard)
     *
     * @see Solution1#largestRectangleArea(int[])
     * @see Solution201#maximalSquare(char[][])
     * @see <a href="https://leetcode-cn.com/problems/maximal-rectangle/">Maximal Rectangle</a>
     */
    public int maximalRectangle(char[][] matrix) {
        // todo
        return 0;
    }

    /**
     * 86. Partition List (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/partition-list/">Partition List</a>
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0), rightHead = new ListNode(0);
        ListNode left = leftHead, right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        if (leftHead.next == null) {
            return rightHead.next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }

    /**
     * 87. Scramble String (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/scramble-string/">Scramble String</a>
     */
    public boolean isScramble(String s1, String s2) {
        // todo
        return false;
    }

    /**
     * 88. Merge Sorted Array (Easy)
     *
     * @see Solution1#mergeTwoLists(ListNode, ListNode)
     * @see Solution901#sortedSquares(int[])
     * @see Solution901#intervalIntersection(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array/">Merge Sorted Array</a>
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[index--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }

    /**
     * 89. Gray Code (Medium)
     * <p>
     * g(n+1) = g(n) + Reverse(g(n)+2^n)
     *
     * @see Solution701#isOneBitCharacter(int[])
     * @see <a href="https://leetcode-cn.com/problems/gray-code/">Gray Code</a>
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        grayCode(res, n);
        return res;
    }

    private int grayCode(List<Integer> res, int n) {
        if (n == 1) {
            res.add(0);
            res.add(1);
            return 2;
        }
        int power = grayCode(res, n - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            res.add(res.get(i) + power);
        }
        return power * 2;
    }

    /**
     * 89.2 Gray Code (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/gray-code/">Gray Code</a>
     */
    public List<Integer> grayCode2(int n) {
        int count = 1 << n;
        List<Integer> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    /**
     * 90. Subsets II (Medium)
     *
     * @see Solution1#subsets(int[])
     * @see <a href="https://leetcode-cn.com/problems/subsets-ii/">Subsets II</a>
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup(res, nums, new ArrayList<>(), 0);
        return res;
    }

    /**
     * @param temp chosen numbers from [i+1,length)
     * @param i    the first index of a distinct number to be chosen or not
     */
    private void subsetsWithDup(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        int j = i + 1, val = nums[i];
        while (j < nums.length && nums[j] == val) {
            j++;
        }
        // without this value
        subsetsWithDup(res, nums, temp, j);
        for (int k = i; k < j; k++) {
            // with this value of k-i+1 numbers
            temp.add(val);
            subsetsWithDup(res, nums, temp, j);
        }
        // restore
        for (int k = i; k < j; k++) {
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 91. Decode Ways (Medium)
     *
     * @see Solution601#numDecodings(String)
     * @see <a href="https://leetcode-cn.com/problems/decode-ways/">Decode Ways</a>
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] res = new int[len];
        res[0] = chars[0] == '0' ? 0 : 1;
        if (len == 1) {
            return res[0];
        }

        if (chars[1] > '0') {
            res[1] += res[0];
        }
        if (chars[0] == '1' || (chars[0] == '2' && chars[1] <= '6')) {
            res[1] += 1;
        }
        for (int i = 2; i < len; i++) {
            if (chars[i] > '0') {
                res[i] += res[i - 1];
            }
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                res[i] += res[i - 2];
            }
        }
        return res[len - 1];
    }

    /**
     * 92. Reverse Linked List II (Medium)
     *
     * @see Solution201#reverseList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">Reverse Linked List
     * II</a>
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);
        ListNode pre = res;
        while (left-- > 1) {
            pre = pre.next;
            right--;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pre.next;
        while (right-- > 0) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            ListNode top = stack.pop();
            // cut to prevent a circle
            top.next = null;
            pre.next = top;
            pre = top;
        }
        pre.next = cur;
        return res.next;
    }

    /**
     * 93. Restore IP Addresses (Medium)
     *
     * @see #BACKTRACKING
     * @see #TIME_NN
     * @see Solution701#ipToCIDR(String, int)
     * @see <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">Restore IP
     * Addresses</a>
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(res, s.toCharArray(), new StringBuilder(15), 4, 0);
        return res;
    }

    /**
     * @param temp store chosen part
     * @param left left integers to be chosen, range [0,4]
     * @param i    the start index of chars to be chosen
     */
    private void restoreIpAddresses(List<String> res, char[] chars, StringBuilder temp, int left,
        int i) {
        if (i == chars.length || left == 0) {
            if (i == chars.length && left == 0) {
                // all chars used for four integers
                res.add(temp.toString());
            }
            return;
        }
        if (left * 3 + i < chars.length || left + i > chars.length) {
            // if the left chars are too many or not enough
            return;
        }
        left--;
        int len = temp.length();
        if (len != 0) {
            temp.append('.');
        }
        int val = chars[i] - '0';
        // 0-9
        temp.append(chars[i++]);
        restoreIpAddresses(res, chars, temp, left, i);
        if (i < chars.length) {
            val = val * 10 + chars[i] - '0';
            if (val >= 10) {
                // 10-99
                temp.append(chars[i++]);
                restoreIpAddresses(res, chars, temp, left, i);
                if (i < chars.length) {
                    val = val * 10 + chars[i] - '0';
                    if (val >= 100 && val <= 255) {
                        // 100-255
                        temp.append(chars[i++]);
                        restoreIpAddresses(res, chars, temp, left, i);
                    }
                }
            }
        }
        temp.delete(len, temp.length());
    }

    /**
     * 94. Binary Tree Inorder Traversal (Easy)
     *
     * @see Solution1#isValidBST(TreeNode)
     * @see Solution101#preorderTraversal(TreeNode)
     * @see Solution101#postorderTraversal(TreeNode)
     * @see BSTIterator
     * @see Solution201#kthSmallest(TreeNode, int)
     * @see Solution201#closestKValues(TreeNode, double, int)
     * @see Solution201#inorderSuccessor(TreeNode, int)
     * @see Solution401#treeToDoublyList(TreeNode)
     * @see Solution701#minDiffInBST(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">Binary Tree
     * Inorder Traversal</a>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }

    /**
     * 94.2 Binary Tree Inorder Traversal (Easy) (Stack)
     *
     * @see Solution101#preorderTraversal2(TreeNode)
     * @see Solution101#postorderTraversal2(TreeNode)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }

    /**
     * 95. Unique Binary Search Trees II (Medium)
     *
     * @see Solution1#numTrees(int)
     * @see Solution201#diffWaysToCompute(String)
     * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees-ii/">Unique Binary
     * Search Trees II</a>
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = generateTrees(min, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, max);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        return res;
    }

    /**
     * 96. Unique Binary Search Trees (Medium)
     * <p>
     * f(k) = f(0)*f(k-1) + f(1)*f(k-2) + ... + f(k-1)*f(0)
     *
     * @see Solution1#generateTrees(int)
     * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">Unique Binary
     * Search Trees</a>
     */
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                res[k] += res[i] * res[k - 1 - i];
            }
        }
        return res[n];
    }

    /**
     * 97. Interleaving String (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_MN
     * @see #SPACE_MN
     * @see <a href="https://leetcode-cn.com/problems/interleaving-string/">Interleaving String</a>
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        boolean[][] res = new boolean[len1 + 1][len2 + 1];
        res[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            res[i][0] = res[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= len2; j++) {
            res[0][j] = res[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char ch3 = s3.charAt(i + j - 1);
                res[i][j] = (s1.charAt(i - 1) == ch3 && res[i - 1][j])
                    || (s2.charAt(j - 1) == ch3 && res[i][j - 1]);
            }
        }
        return res[len1][len2];
    }

    /**
     * 98. Validate Binary Search Tree (Medium)
     *
     * @see #DFS
     * @see #TIME_N
     * @see #SPACE_N
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution501#findMode(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">Validate Binary
     * Search Tree</a>
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * All values of the tree should be in the range (min, max), both exclusive.
     */
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        int val = node.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        return (node.left == null || isValidBST(node.left, min, val))
            && (node.right == null || isValidBST(node.right, val, max));
    }

    /**
     * 99. Recover Binary Search Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/recover-binary-search-tree/">Recover Binary
     * Search Tree</a>
     */
    public void recoverTree(TreeNode root) {
        // todo
    }

    /**
     * 100. Same Tree (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/same-tree/">Same Tree</a>
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        return q != null && p.val == q.val
            && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}