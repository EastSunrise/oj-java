package wsg.oj.java.leetcode.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution301 extends Solution {

    /**
     * 306. Additive Number (Medium)
     *
     * @see #DFS
     * @see BigInteger
     * @see Solution801#splitIntoFibonacci(String)
     * @see <a href="https://leetcode-cn.com/problems/additive-number/">Additive Number</a>
     */
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len <= 2) {
            return false;
        }
        char[] chars = num.toCharArray();
        for (int b = 1; b < len; b++) {
            for (int c = b + 1; c < len; c++) {
                if (isAdditiveNumber(chars, 0, b, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(char[] chars, int a, int b, int c) {
        if ((chars[a] == '0' && b - a > 1) || (chars[b] == '0' && c - b > 1)) {
            // leading zeros
            return false;
        }
        int cLen = Math.max(b - a, c - b);
        if (c + cLen > chars.length) {
            // not enough chars left
            return false;
        }
        int[] temp = new int[cLen];
        int i = b - 1, j = c - 1, k = cLen - 1, carry = 0;
        while (i >= a && j >= b) {
            int sum = chars[i--] - '0' + chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (i >= a) {
            int sum = chars[i--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (j >= b) {
            int sum = +chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        k = c;
        if (carry > 0) {
            if (chars[k++] - '0' != carry) {
                return false;
            }
        }
        for (int digit : temp) {
            if (chars[k++] - '0' != digit) {
                return false;
            }
        }
        if (k == chars.length) {
            return true;
        }
        return isAdditiveNumber(chars, b, c, k);
    }


    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_N
     * @see #SPACE_N
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfitII(int[])
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best
     * Time to Buy and Sell Stock with Cooldown</a>
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        // be holding a stock after i days
        int[] holding = new int[len];
        // be cooldown after i days
        int[] cooldown = new int[len];
        // not hold a stock and not cooldown after i days
        int[] free = new int[len];
        holding[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            holding[i] = Math.max(holding[i - 1], free[i - 1] - prices[i]);
            cooldown[i] = holding[i - 1] + prices[i];
            free[i] = Math.max(free[i - 1], cooldown[i - 1]);
        }
        return Math.max(cooldown[len - 1], free[len - 1]);
    }

    /**
     * 310. Minimum Height Trees (Medium)
     * <p>
     * todo
     *
     * @see Solution201#canFinish(int, int[][])
     * @see Solution201#findOrder(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/minimum-height-trees/">Minimum Height
     * Trees</a>
     */
    public int[] findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        // distances[i]: the distance between i and a given key
        int[] distances = new int[n];
        distances[0] = 1;
        // find one side of the longest path
        int left = findFurthest(map, 0, distances);
        Arrays.fill(distances, 0);
        distances[left] = 1;
        // find the other side of the longest path
        int right = findFurthest(map, left, distances);
        Arrays.fill(distances, 0);
        // find the longest path
        List<Integer> longestPath = new ArrayList<>();
        findPath(map, longestPath, left, right, distances);
        int mid = longestPath.size() / 2;
        if ((longestPath.size() & 1) == 0) {
            return new int[]{longestPath.get(mid - 1), longestPath.get(mid)};
        } else {
            return new int[]{longestPath.get(mid)};
        }
    }

    private int findFurthest(Map<Integer, List<Integer>> edges, int target, int[] distances) {
        int furthest = target;
        for (int vertex : edges.get(target)) {
            if (distances[vertex] == 0) {
                distances[vertex] = distances[target] + 1;
                int res = findFurthest(edges, vertex, distances);
                if (distances[res] > distances[furthest]) {
                    furthest = res;
                }
            }
        }
        return furthest;
    }

    private boolean findPath(Map<Integer, List<Integer>> edges, List<Integer> path, int cur,
        int target, int[] visited) {
        if (visited[cur] == 1) {
            return false;
        }
        if (cur == target) {
            path.add(cur);
            return true;
        }
        visited[cur] = 1;
        path.add(cur);
        for (int vertex : edges.get(cur)) {
            if (findPath(edges, path, vertex, target, visited)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * 313. Super Ugly Number (Medium)
     *
     * @see Solution201#nthUglyNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/super-ugly-number/">Super Ugly Number</a>
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] indices = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = primes[0] * dp[indices[0]];
            int idx = 0;
            for (int p = 1; p < indices.length; p++) {
                int next = primes[p] * dp[indices[p]];
                if (next < dp[i]) {
                    dp[i] = next;
                    idx = p;
                }
            }
            indices[idx]++;
            if (dp[i] == dp[i - 1]) {
                i--;
            }
        }
        return dp[n - 1];
    }

    /**
     * 316. Remove Duplicate Letters (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicate-letters/">Remove Duplicate
     * Letters</a>
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] added = new boolean[26];
        int[] remaining = new int[26];
        for (char ch : s.toCharArray()) {
            remaining[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            remaining[idx]--;
            if (added[idx]) {
                // since the stack is increasing except the distinct ones
                // ignore this one of the duplicate character
                continue;
            }
            // think of the top of the stack: x
            // if there is another x after c, choose which x to be removed
            // if x>c, remove this x since x+c > c+x
            while (!stack.isEmpty() && remaining[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                added[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            added[idx] = true;
        }
        StringBuilder builder = new StringBuilder(stack.size());
        for (Character ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }

    /**
     * 318. Maximum Product of Word Lengths (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-product-of-word-lengths/">Maximum
     * Product of Word Lengths</a>
     */
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] hashes = new int[len];
        for (int i = 0; i < len; i++) {
            for (char ch : words[i].toCharArray()) {
                hashes[i] |= 1 << (ch - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if ((hashes[i] & hashes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    /**
     * 319. Bulb Switcher (Medium)
     *
     * @see Solution601#flipLights(int, int)
     * @see Solution901#minKBitFlips(int[], int)
     * @see Solution1301#numTimesAllBlue(int[])
     * @see <a href="https://leetcode-cn.com/problems/bulb-switcher/">Bulb Switcher</a>
     */
    public int bulbSwitch(int n) {
        // the count of switching ith bulb is represented as the count of factors of the number i
        // the bulb will be on if and only if the count of factors is odd
        // which means the number i is a square
        // so find the count of squares within n
        return (int) Math.sqrt(n);
    }

    /**
     * 326. Power of Three (Easy)
     *
     * @see Solution201#isPowerOfTwo(int)
     * @see Solution301#isPowerOfFour(int)
     * @see Solution1701#checkPowersOfThree(int)
     * @see <a href="https://leetcode-cn.com/problems/power-of-three/">Power of Three</a>
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 338. Counting Bits (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/counting-bits/">Counting Bits</a>
     */
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        int start = 1;
        while (start <= n) {
            int maxLen = start;
            counts[start++] = 1;
            for (int len = 1; len < maxLen; len *= 2) {
                for (int i = 0; i < len; i++) {
                    if (start > n) {
                        return counts;
                    }
                    counts[start] = counts[start - len] + 1;
                    start++;
                }
            }
        }
        return counts;
    }

    /**
     * 338.2 Counting Bits (Easy) (Bit)
     */
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = res[i >> 1] + (i % 2);
        }
        return res;
    }

    /**
     * 342. Power of Four (Easy)
     *
     * @see Solution201#isPowerOfTwo(int)
     * @see Solution201#isPowerOfTwo2(int)
     * @see Solution301#isPowerOfThree(int)
     * @see <a href="https://leetcode-cn.com/problems/power-of-four/">Power of Four</a>
     */
    public boolean isPowerOfFour(int n) {
        // even not power of 2
        if (n < 1 || (n & (n - 1)) != 0) {
            return false;
        }
        // a power of 2 = (3-1)^n = 3k + (-1)^n
        return n % 3 == 1;
    }

    /**
     * 344. Reverse String (Easy)
     *
     * @see Solution301#reverseVowels(String)
     * @see Solution501#reverseStr(String, int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-string/">Reverse String</a>
     */
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    /**
     * 345. Reverse Vowels of a String (Easy)
     *
     * @see Solution301#reverseString(char[])
     * @see Solution1101#removeVowels(String)
     * @see <a href="https://leetcode-cn.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of
     * a String</a>
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && notVowel(chars[left])) {
                left++;
            }
            while (left < right && notVowel(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    private boolean notVowel(char ch) {
        if (ch > 'U') {
            ch -= 32;
        }
        return ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }

    /**
     * 349. Intersection of Two Arrays (Easy)
     *
     * @see Solution301#intersect(int[], int[])
     * @see Solution1201#arraysIntersection(int[], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/">Intersection of
     * Two Arrays</a>
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer value : set1) {
            res[i++] = value;
        }
        return res;
    }

    /**
     * 350. Intersection of Two Arrays II (Easy)
     *
     * @see Solution301#intersection(int[], int[])
     * @see Solution1001#commonChars(String[])
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/">Intersection
     * of Two Arrays II</a>
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] frequency1 = new int[1001];
        for (int num : nums1) {
            frequency1[num]++;
        }
        int[] frequency2 = new int[1001];
        for (int num : nums2) {
            frequency2[num]++;
        }
        int len = 0;
        for (int i = 0; i < 1001; i++) {
            frequency1[i] = Math.min(frequency1[i], frequency2[i]);
            len += frequency1[i];
        }
        int[] res = new int[len];
        int i = 0;
        for (int j = 0; j < 1001; j++) {
            Arrays.fill(res, i, i + frequency1[j], j);
            i += frequency1[j];
        }
        return res;
    }

    /**
     * 367. Valid Perfect Square (Easy)
     *
     * @see Solution1#mySqrt(int)
     * @see Solution601#judgeSquareSum(int)
     * @see <a href="https://leetcode-cn.com/problems/valid-perfect-square/">Valid Perfect
     * Square</a>
     */
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left < right) {
            right = (left + right) >> 1;
            left = num / right;
        }
        return right * right == num;
    }

    /**
     * 374. Guess Number Higher or Lower (Easy)
     *
     * @see Solution201#firstBadVersion(int)
     * @see Solution301#getMoneyAmount(int)
     * @see Solution601#findClosestElements(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower/">Guess Number
     * Higher or Lower</a>
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int res = guess(mid);
            if (res < 0) {
                high = mid - 1;
            } else if (res > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return Integer.compare(num, 6);
    }

    /**
     * 383. Ransom Note (Easy)
     *
     * @see Solution601#minStickers(String[], String)
     * @see <a href="https://leetcode-cn.com/problems/ransom-note/">Ransom Note</a>
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        char[] ms = magazine.toCharArray();
        for (char ch : ms) {
            counts[ch - 'a']++;
        }
        char[] rs = ransomNote.toCharArray();
        for (char ch : rs) {
            if (counts[ch - 'a'] == 0) {
                return false;
            } else {
                counts[ch - 'a']--;
            }
        }
        return true;
    }

    /**
     * 387. First Unique Character in a String (Easy)
     *
     * @see Solution401#frequencySort(String)
     * @see <a href="https://leetcode-cn.com/problems/first-unique-character-in-a-string/">First
     * Unique Character in a String</a>
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        // [i][0]: count of char i+'a', [i][1]: first index of char i+'a'
        int[][] counts = new int[26][2];
        for (int i = chars.length - 1; i >= 0; i--) {
            int ch = chars[i] - 'a';
            counts[ch][0]++;
            counts[ch][1] = i;
        }
        int first = chars.length;
        for (int[] count : counts) {
            if (count[0] == 1 && count[1] < first) {
                first = count[1];
            }
        }
        return first == chars.length ? -1 : first;
    }

    /**
     * 389. Find the Difference (Easy)
     *
     * @see Solution101#singleNumber(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-the-difference/">Find the Difference</a>
     */
    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        int sum = 0;
        for (char c : sChars) {
            sum ^= c;
        }
        for (char c : tChars) {
            sum ^= c;
        }
        return (char) sum;
    }

    /**
     * 392. Is Subsequence (Easy)
     *
     * @see Solution701#numMatchingSubseq(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/is-subsequence/">Is Subsequence</a>
     */
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int si = sChars.length - 1, ti = tChars.length - 1;
        while (si >= 0 && ti >= 0) {
            if (sChars[si] == tChars[ti]) {
                si--;
            }
            ti--;
        }
        return si < 0;
    }
}