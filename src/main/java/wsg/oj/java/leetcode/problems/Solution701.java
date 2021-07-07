package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.701-No.800.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution701 extends Solution {

    int[] goods = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    /**
     * 704. Binary Search (Easy)
     *
     * @see Arrays#binarySearch(int[], int)
     * @see Solution1#searchInsert(int[], int)
     * @see Solution701#search(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/binary-search/">Binary Search</a>
     */
    public int searchII(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 709. To Lower Case (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/to-lower-case/">To Lower Case</a>
     */
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    /**
     * 717. 1-bit and 2-bit Characters (Easy)
     *
     * @see Solution1#grayCode(int)
     * @see <a href="https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit
     * Characters</a>
     */
    public boolean isOneBitCharacter(int[] bits) {
        // count the number of contiguous 1 before the last 0
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) {
            i--;
        }
        return ((bits.length - i) & 1) == 0;
    }

    /**
     * 724. Find Pivot Index (Easy)
     *
     * @see Solution501#subarraySum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/find-pivot-index/">Find Pivot Index</a>
     */
    public int pivotIndex(int[] nums) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 1; i < nums.length; i++) {
            sumRight += nums[i];
        }
        int i = 0, end = nums.length - 1;
        while (i < end) {
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
            i++;
            sumRight -= nums[i];
        }
        return sumLeft == sumRight ? i : -1;
    }

    /**
     * 728. Self Dividing Numbers (Easy)
     *
     * @see Solution501#checkPerfectNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/self-dividing-numbers/">Self Dividing
     * Numbers</a>
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDividingNumber(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    /**
     * 744. Find Smallest Letter Greater Than Target (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/">Find
     * Smallest Letter Greater Than Target</a>
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }


    /**
     * 746. Min Cost Climbing Stairs (Easy)
     *
     * @see Solution1#climbStairs(int)
     * @see <a href="https://leetcode-cn.com/problems/min-cost-climbing-stairs/">Min Cost Climbing
     * Stairs</a>
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] sum = new int[len];
        sum[0] = cost[0];
        sum[1] = cost[1];
        for (int i = 2; i < len; i++) {
            sum[i] = Math.min(sum[i - 2] + cost[i], sum[i - 1] + cost[i]);
        }
        return Math.min(sum[len - 1], sum[len - 2]);
    }

    /**
     * 747. Largest Number At Least Twice of Others (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/">Largest
     * Number At Least Twice of Others</a>
     */
    public int dominantIndex(int[] nums) {
        int res = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > max && i != res) {
                return -1;
            }
        }
        return res;
    }

    /**
     * 748. Shortest Completing Word (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-completing-word/">Shortest Completing
     * Word</a>
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] frequency = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                frequency[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                frequency[ch - 'A']++;
            }
        }
        String target = null;
        int len = 16;
        for (String word : words) {
            int[] copy = Arrays.copyOf(frequency, 26);
            if (isCompleted(word, copy) && word.length() < len) {
                target = word;
                len = word.length();
            }
        }
        return target;
    }

    private boolean isCompleted(String word, int[] frequency) {
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            frequency[i]--;
        }
        for (int i : frequency) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 762. Prime Number of Set Bits in Binary Representation (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/">Prime
     * Number of Set Bits in Binary Representation</a>
     */
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 771. Jewels and Stones (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/jewels-and-stones/">Jewels and Stones</a>
     */
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean['z' - 'A' + 1];
        for (char ch : jewels.toCharArray()) {
            isJewel[ch - 'A'] = true;
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (isJewel[ch - 'A']) {
                count++;
            }
        }
        return count;
    }

    /**
     * 783. Minimum Distance Between BST Nodes (Easy) (Same as {@link Solution501#getMinimumDifference(TreeNode)})
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">Minimum
     * Distance Between BST Nodes</a>
     */
    public int minDiffInBST(TreeNode root) {
        return 0;
    }

    /**
     * 788. Rotated Digits (Easy)
     * <p>
     * Assumes that f(n) is the good numbers from 1 to 10^n. Then
     * <i>f(n+1) = 3f(n) + 4 * 7^n</i>
     *
     * @see <a href="https://leetcode-cn.com/problems/rotated-digits/">Rotated Digits</a>
     */
    public int rotatedDigits(int n) {
        int temp = n, left = 1, base = 0, power = 1;
        while (temp > 9) {
            temp /= 10;
            left *= 10;
            base = base * 3 + 4 * power;
            power *= 7;
        }
        int res = 0;
        for (int i = left + 1; i <= n; i++) {
            if (isGood(i)) {
                res++;
            }
        }
        return res + base;
    }

    private boolean isGood(int num) {
        boolean flag = false;
        while (num > 0) {
            int digit = num % 10;
            if (goods[digit] < 0) {
                return false;
            } else if (goods[digit] > 0) {
                flag = true;
            }
            num /= 10;
        }
        return flag;
    }

    /**
     * 796. Rotate String (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/rotate-string/">Rotate String</a>
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int len = goal.length();
        if (len == 0) {
            return true;
        }
        return (goal + goal).substring(1, 2 * len - 1).contains(s);
    }
}