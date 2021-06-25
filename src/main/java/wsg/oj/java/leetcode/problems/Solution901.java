package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solutions to problems No.901-No.1000.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution901 extends Solution {


    /**
     * 902. Numbers At Most N Given Digit Set (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set/">Numbers At
     * Most N Given Digit Set</a>
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // todo
        return 0;
    }

    /**
     * 903. Valid Permutations for DI Sequence (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/valid-permutations-for-di-sequence/">Valid
     * Permutations for DI Sequence</a>
     */
    public int numPermsDISequence(String s) {
        // todo
        return 0;
    }

    /**
     * 904. Fruit Into Baskets (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
     */
    public int totalFruit(int[] fruits) {
        // todo
        return 0;
    }

    /**
     * 905. Sort Array By Parity (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/sort-array-by-parity/">Sort Array By
     * Parity</a>
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else if (nums[right] % 2 == 1) {
                right--;
            } else {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
        return nums;
    }

    /**
     * 906. Super Palindromes (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/super-palindromes/">Super Palindromes</a>
     */
    public int superpalindromesInRange(String left, String right) {
        // todo
        return 0;
    }

    /**
     * 907. Sum of Subarray Minimums (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/sum-of-subarray-minimums/">Sum of Subarray
     * Minimums</a>
     */
    public int sumSubarrayMins(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 908. Smallest Range I (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/smallest-range-i/">Smallest Range I</a>
     */
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }
        min += 2 * k;
        return max > min ? max - min : 0;
    }

    /**
     * 909. Snakes and Ladders (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/snakes-and-ladders/">Snakes and Ladders</a>
     */
    public int snakesAndLadders(int[][] board) {
        // todo
        return 0;
    }

    /**
     * 910. Smallest Range II (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/smallest-range-ii/">Smallest Range II</a>
     */
    public int smallestRangeII(int[] nums, int k) {
        // todo
        return 0;
    }


    /**
     * 912. Sort an Array (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/sort-an-array/">Sort an Array</a>
     */
    public int[] sortArray(int[] nums) {
        // todo
        return new int[0];
    }

    /**
     * 913. Cat and Mouse (Hard)
     *
     * @see Solution1701#canMouseWin(String[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/cat-and-mouse/">Cat and Mouse</a>
     */
    public int catMouseGame(int[][] graph) {
        // todo
        return 0;
    }

    /**
     * 914. X of a Kind in a Deck of Cards (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/">X of a Kind
     * in a Deck of Cards</a>
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> frequency = new HashMap<>(4);
        for (int num : deck) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int gcd = 0;
        for (int count : frequency.values()) {
            gcd = gcd(gcd, count);
            if (gcd < 2) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    /**
     * 915. Partition Array into Disjoint Intervals (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals/">Partition
     * Array into Disjoint Intervals</a>
     */
    public int partitionDisjoint(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 916. Word Subsets (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/word-subsets/">Word Subsets</a>
     */
    public String[] wordSubsets(String[] words1, String[] words2) {
        // todo
        return new String[0];
    }

    /**
     * 917. Reverse Only Letters (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/reverse-only-letters/">Reverse Only
     * Letters</a>
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (notLetter(chars[left])) {
                left++;
            } else if (notLetter(chars[right])) {
                right--;
            } else {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        }
        return new String(chars);
    }

    private boolean notLetter(char ch) {
        return ch < 'A' || ch > 'z' || (ch > 'Z' && ch < 'a');
    }

    /**
     * 918. Maximum Sum Circular Subarray (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-sum-circular-subarray/">Maximum Sum
     * Circular Subarray</a>
     */
    public int maxSubarraySumCircular(int[] nums) {
        // todo
        return 0;
    }


    /**
     * 920. Number of Music Playlists (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-of-music-playlists/">Number of Music
     * Playlists</a>
     */
    public int numMusicPlaylists(int n, int goal, int k) {
        // todo
        return 0;
    }

    /**
     * 921. Minimum Add to Make Parentheses Valid (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/">Minimum
     * Add to Make Parentheses Valid</a>
     */
    public int minAddToMakeValid(String s) {
        // todo
        return 0;
    }

    /**
     * 922. Sort Array By Parity II (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/sort-array-by-parity-ii/">Sort Array By Parity
     * II</a>
     */
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int ei = 0, oi = 1;
        while (ei < len && oi < len) {
            if (nums[ei] % 2 == 0) {
                ei += 2;
            } else if (nums[oi] % 2 == 1) {
                oi += 2;
            } else {
                nums[ei] += nums[oi];
                nums[oi] = nums[ei] - nums[oi];
                nums[ei] -= nums[oi];
                ei += 2;
                oi += 2;
            }
        }
        return nums;
    }

    /**
     * 923. 3Sum With Multiplicity (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/3sum-with-multiplicity/">3Sum With
     * Multiplicity</a>
     */
    public int threeSumMulti(int[] arr, int target) {
        // todo
        return 0;
    }

    /**
     * 924. Minimize Malware Spread (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimize-malware-spread/">Minimize Malware
     * Spread</a>
     */
    public int minMalwareSpread(int[][] graph, int[] initial) {
        // todo
        return 0;
    }

    /**
     * 925. Long Pressed Name (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/long-pressed-name/">Long Pressed Name</a>
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int nl = name.length(), tl = typed.length();
        if (nl > typed.length()) {
            return false;
        }
        int ni = 1, ti = 1;
        while (ni < nl && ti < tl) {
            if (name.charAt(ni) == typed.charAt(ti)) {
                ni++;
                ti++;
            } else if (name.charAt(ni - 1) == typed.charAt(ti)) {
                ti++;
            } else {
                return false;
            }
        }
        if (ni < nl) {
            return false;
        }
        char last = name.charAt(nl - 1);
        while (ti < tl) {
            if (typed.charAt(ti++) != last) {
                return false;
            }
        }
        return true;
    }

    /**
     * 926. Flip String to Monotone Increasing (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/">Flip
     * String to Monotone Increasing</a>
     */
    public int minFlipsMonoIncr(String s) {
        // todo
        return 0;
    }

    /**
     * 927. Three Equal Parts (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/three-equal-parts/">Three Equal Parts</a>
     */
    public int[] threeEqualParts(int[] arr) {
        // todo
        return new int[0];
    }

    /**
     * 928. Minimize Malware Spread II (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimize-malware-spread-ii/">Minimize Malware
     * Spread II</a>
     */
    public int minMalwareSpreadII(int[][] graph, int[] initial) {
        // todo
        return 0;
    }

    /**
     * 929. Unique Email Addresses (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/unique-email-addresses/">Unique Email
     * Addresses</a>
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int at = email.indexOf('@');
            int plus = email.indexOf('+');
            if (plus < 0 || plus > at) {
                plus = at;
            }
            StringBuilder builder = new StringBuilder(email.length());
            for (int i = 0; i < plus; i++) {
                char ch = email.charAt(i);
                if (ch != '.') {
                    builder.append(ch);
                }
            }
            builder.append(email, at, email.length());
            set.add(builder.toString());
        }
        return set.size();
    }

    /**
     * 930. Binary Subarrays With Sum (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/binary-subarrays-with-sum/">Binary Subarrays
     * With Sum</a>
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        // todo
        return 0;
    }

    /**
     * 931. Minimum Falling Path Sum (Medium)
     *
     * @see Solution1201#minFallingPathSum(int[][])
     * @see <a href="https://leetcode-cn.com/problems/minimum-falling-path-sum/">Minimum Falling
     * Path Sum</a>
     */
    public int minFallingPathSum(int[][] matrix) {
        // todo
        return 0;
    }

    /**
     * 932. Beautiful Array (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/beautiful-array/">Beautiful Array</a>
     */
    public int[] beautifulArray(int n) {
        // todo
        return new int[0];
    }


    /**
     * 934. Shortest Bridge (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-bridge/">Shortest Bridge</a>
     */
    public int shortestBridge(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 935. Knight Dialer (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/knight-dialer/">Knight Dialer</a>
     */
    public int knightDialer(int n) {
        // todo
        return 0;
    }

    /**
     * 936. Stamping The Sequence (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/stamping-the-sequence/">Stamping The
     * Sequence</a>
     */
    public int[] movesToStamp(String stamp, String target) {
        // todo
        return new int[0];
    }

    /**
     * 937. Reorder Data in Log Files (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/reorder-data-in-log-files/">Reorder Data in
     * Log Files</a>
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            boolean flag1 = isLetterLog(o1);
            boolean flag2 = isLetterLog(o2);
            if (flag1 && flag2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i1 = o1.indexOf(' ') + 1;
                int i2 = o2.indexOf(' ') + 1;
                int res = Arrays.compare(chars1, i1, o1.length(), chars2, i2, o2.length());
                if (res != 0) {
                    return res;
                }
                return Arrays.compare(chars1, 0, i1, chars2, 0, i2);
            }
            return Boolean.compare(flag2, flag1);

        });
        return logs;
    }

    private boolean isLetterLog(String log) {
        return log.charAt(log.length() - 1) > '9';
    }

    /**
     * 938. Range Sum of BST (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">Range Sum of BST</a>
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 939. Minimum Area Rectangle (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-area-rectangle/">Minimum Area
     * Rectangle</a>
     */
    public int minAreaRect(int[][] points) {
        // todo
        return 0;
    }

    /**
     * 940. Distinct Subsequences II (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/distinct-subsequences-ii/">Distinct
     * Subsequences II</a>
     */
    public int distinctSubseqII(String s) {
        // todo
        return 0;
    }

    /**
     * 941. Valid Mountain Array (Easy)
     *
     * @see Solution801#peakIndexInMountainArray(int[])
     * @see Solution1601#minimumMountainRemovals(int[])
     * @see <a href="https://leetcode-cn.com/problems/valid-mountain-array/">Valid Mountain
     * Array</a>
     */
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }
        int i = 1;
        while (i < len && arr[i] > arr[i - 1]) {
            i++;
        }
        if (i == 1 || i == len) {
            return false;
        }
        while (i < len && arr[i] < arr[i - 1]) {
            i++;
        }
        return i == len;
    }

    /**
     * 942. DI String Match (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/di-string-match/">DI String Match</a>
     */
    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        char[] chars = s.toCharArray();
        int low = 0, high = len;
        for (int i = 0; i < len; i++) {
            res[i] = chars[i] == 'I' ? low++ : high--;
        }
        res[len] = low;
        return res;
    }

    /**
     * 943. Find the Shortest Superstring (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-the-shortest-superstring/">Find the
     * Shortest Superstring</a>
     */
    public String shortestSuperstring(String[] words) {
        // todo
        return "";
    }

    /**
     * 944. Delete Columns to Make Sorted (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/delete-columns-to-make-sorted/">Delete Columns
     * to Make Sorted</a>
     */
    public int minDeletionSize(String[] strs) {
        int n = strs.length, len = strs[0].length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 945. Minimum Increment to Make Array Unique (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/">Minimum
     * Increment to Make Array Unique</a>
     */
    public int minIncrementForUnique(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 946. Validate Stack Sequences (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/validate-stack-sequences/">Validate Stack
     * Sequences</a>
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // todo
        return false;
    }

    /**
     * 947. Most Stones Removed with Same Row or Column (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/">Most
     * Stones Removed with Same Row or Column</a>
     */
    public int removeStones(int[][] stones) {
        // todo
        return 0;
    }

    /**
     * 948. Bag of Tokens (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/bag-of-tokens/">Bag of Tokens</a>
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        // todo
        return 0;
    }

    /**
     * 949. Largest Time for Given Digits (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-time-for-given-digits/">Largest Time
     * for Given Digits</a>
     */
    public String largestTimeFromDigits(int[] arr) {
        // todo
        return "";
    }

    /**
     * 950. Reveal Cards In Increasing Order (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/reveal-cards-in-increasing-order/">Reveal
     * Cards In Increasing Order</a>
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        // todo
        return new int[0];
    }

    /**
     * 951. Flip Equivalent Binary Trees (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/flip-equivalent-binary-trees/">Flip Equivalent
     * Binary Trees</a>
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // todo
        return false;
    }

    /**
     * 952. Largest Component Size by Common Factor (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-component-size-by-common-factor/">Largest
     * Component Size by Common Factor</a>
     */
    public int largestComponentSize(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 953. Verifying an Alien Dictionary (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/verifying-an-alien-dictionary/">Verifying an
     * Alien Dictionary</a>
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < 26; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compareAlienString(words[i - 1], words[i], dict) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compareAlienString(String s1, String s2, int[] dict) {
        int i = 0, len1 = s1.length(), len2 = s2.length();
        while (i < len1 && i < len2) {
            int comp = dict[s1.charAt(i) - 'a'] - dict[s2.charAt(i) - 'a'];
            if (comp != 0) {
                return comp;
            }
            i++;
        }
        return len1 - len2;
    }

    /**
     * 954. Array of Doubled Pairs (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/array-of-doubled-pairs/">Array of Doubled
     * Pairs</a>
     */
    public boolean canReorderDoubled(int[] arr) {
        // todo
        return false;
    }

    /**
     * 955. Delete Columns to Make Sorted II (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/delete-columns-to-make-sorted-ii/">Delete
     * Columns to Make Sorted II</a>
     */
    public int minDeletionSizeII(String[] strs) {
        // todo
        return 0;
    }

    /**
     * 956. Tallest Billboard (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/tallest-billboard/">Tallest Billboard</a>
     */
    public int tallestBillboard(int[] rods) {
        // todo
        return 0;
    }

    /**
     * 957. Prison Cells After N Days (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/prison-cells-after-n-days/">Prison Cells After
     * N Days</a>
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        // todo
        return new int[0];
    }

    /**
     * 958. Check Completeness of a Binary Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/">Check
     * Completeness of a Binary Tree</a>
     */
    public boolean isCompleteTree(TreeNode root) {
        // todo
        return false;
    }

    /**
     * 959. Regions Cut By Slashes (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/regions-cut-by-slashes/">Regions Cut By
     * Slashes</a>
     */
    public int regionsBySlashes(String[] grid) {
        // todo
        return 0;
    }

    /**
     * 960. Delete Columns to Make Sorted III (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/delete-columns-to-make-sorted-iii/">Delete
     * Columns to Make Sorted III</a>
     */
    public int minDeletionSizeIII(String[] strs) {
        // todo
        return 0;
    }

    /**
     * 961. N-Repeated Element in Size 2N Array (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated
     * Element in Size 2N Array</a>
     */
    private int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (!set.add(a)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    /**
     * 962. Maximum Width Ramp (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-width-ramp/">Maximum Width Ramp</a>
     */
    public int maxWidthRamp(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 963. Minimum Area Rectangle II (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-area-rectangle-ii/">Minimum Area
     * Rectangle II</a>
     */
    public double minAreaFreeRect(int[][] points) {
        // todo
        return 0.0;
    }

    /**
     * 964. Least Operators to Express Number (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/least-operators-to-express-number/">Least
     * Operators to Express Number</a>
     */
    public int leastOpsExpressTarget(int x, int target) {
        // todo
        return 0;
    }

    /**
     * 965. Univalued Binary Tree (Easy)
     *
     * @see Solution1401#getLonelyNodes(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/univalued-binary-tree/">Univalued Binary
     * Tree</a>
     */
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return val == root.val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }

    /**
     * 966. Vowel Spellchecker (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/vowel-spellchecker/">Vowel Spellchecker</a>
     */
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // todo
        return new String[0];
    }

    /**
     * 967. Numbers With Same Consecutive Differences (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/">Numbers
     * With Same Consecutive Differences</a>
     */
    public int[] numsSameConsecDiff(int n, int k) {
        // todo
        return new int[0];
    }

    /**
     * 968. Binary Tree Cameras (Hard)
     *
     * @see Solution901#distributeCoins(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-cameras/">Binary Tree Cameras</a>
     */
    public int minCameraCover(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 969. Pancake Sorting (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/pancake-sorting/">Pancake Sorting</a>
     */
    public int[] pancakeSort(int[] arr) {
        // todo
        return new int[0];
    }

    /**
     * 970. Powerful Integers (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/powerful-integers/">Powerful Integers</a>
     */
    public int[] powerfulIntegers(int x, int y, int bound) {
        // todo
        return new int[0];
    }

    /**
     * 971. Flip Binary Tree To Match Preorder Traversal (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/">Flip
     * Binary Tree To Match Preorder Traversal</a>
     */
    public int[] flipMatchVoyage(TreeNode root, int[] voyage) {
        // todo
        return new int[0];
    }

    /**
     * 972. Equal Rational Numbers (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/equal-rational-numbers/">Equal Rational
     * Numbers</a>
     */
    public boolean isRationalEqual(String s, String t) {
        // todo
        return false;
    }

    /**
     * 973. K Closest Points to Origin (Medium)
     *
     * @see Solution201#findKthLargest(int[], int)
     * @see Solution301#topKFrequent(int[], int)
     * @see Solution601#topKFrequent(String[], int)
     * @see Solution1701#nearestValidPoint(int, int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/k-closest-points-to-origin/">K Closest Points
     * to Origin</a>
     */
    public int[][] kClosest(int[][] points, int k) {
        // todo
        return new int[0][0];
    }

    /**
     * 974. Subarray Sums Divisible by K (Medium)
     *
     * @see Solution501#subarraySum(int[], int)
     * @see Solution1501#minSubarray(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/">Subarray Sums
     * Divisible by K</a>
     */
    public int subarraysDivByK(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 975. Odd Even Jump (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/odd-even-jump/">Odd Even Jump</a>
     */
    public int oddEvenJumps(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 976. Largest Perimeter Triangle (Easy)
     *
     * @see Solution801#largestTriangleArea(int[][])
     * @see <a href="https://leetcode-cn.com/problems/largest-perimeter-triangle/">Largest Perimeter
     * Triangle</a>
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i >= 2) {
            int sum = nums[i - 2] + nums[i - 1];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
            i--;
        }
        return 0;
    }

    /**
     * 977. Squares of a Sorted Array (Easy)
     *
     * @see Solution1#merge(int[], int, int[], int)
     * @see Solution301#sortTransformedArray(int[], int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/squares-of-a-sorted-array/">Squares of a
     * Sorted Array</a>
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0, len = nums.length;
        while (i < len && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
        }
        int[] res = new int[len];
        int j = i - 1, r = 0;
        while (j >= 0 && i < len) {
            if (nums[i] < nums[j]) {
                res[r] = nums[i] * nums[i];
                i++;
            } else {
                res[r] = nums[j] * nums[j];
                j--;
            }
            r++;
        }
        while (i < len) {
            res[r++] = nums[i] * nums[i++];
        }
        while (j >= 0) {
            res[r++] = nums[j] * nums[j--];
        }
        return res;
    }

    /**
     * 978. Longest Turbulent Subarray (Medium)
     *
     * @see Solution1#maxSubArray(int[])
     * @see <a href="https://leetcode-cn.com/problems/longest-turbulent-subarray/">Longest Turbulent
     * Subarray</a>
     */
    public int maxTurbulenceSize(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 979. Distribute Coins in Binary Tree (Medium)
     *
     * @see Solution801#sumOfDistancesInTree(int, int[][])
     * @see Solution901#minCameraCover(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/">Distribute
     * Coins in Binary Tree</a>
     */
    public int distributeCoins(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 980. Unique Paths III (Hard)
     *
     * @see Solution1#solveSudoku(char[][])
     * @see Solution1#uniquePathsWithObstacles(int[][])
     * @see Solution201#findWords(char[][], String[])
     * @see <a href="https://leetcode-cn.com/problems/unique-paths-iii/">Unique Paths III</a>
     */
    public int uniquePathsIII(int[][] grid) {
        // todo
        return 0;
    }


    /**
     * 982. Triples with Bitwise AND Equal To Zero (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/triples-with-bitwise-and-equal-to-zero/">Triples
     * with Bitwise AND Equal To Zero</a>
     */
    public int countTriplets(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 983. Minimum Cost For Tickets (Medium)
     *
     * @see Solution301#coinChange(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/minimum-cost-for-tickets/">Minimum Cost For
     * Tickets</a>
     */
    public int mincostTickets(int[] days, int[] costs) {
        // todo
        return 0;
    }

    /**
     * 984. String Without AAA or BBB (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/string-without-aaa-or-bbb/">String Without AAA
     * or BBB</a>
     */
    public String strWithout3a3b(int a, int b) {
        // todo
        return "";
    }

    /**
     * 985. Sum of Even Numbers After Queries (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/">Sum of
     * Even Numbers After Queries</a>
     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                sum += num;
            }
        }
        int[] res = new int[queries.length];
        int r = 0;
        for (int[] query : queries) {
            int index = query[1];
            if ((nums[index] & 1) == 0) {
                sum -= nums[index];
            }
            nums[index] += query[0];
            if ((nums[index] & 1) == 0) {
                sum += nums[index];
            }
            res[r++] = sum;
        }
        return res;
    }

    /**
     * 986. Interval List Intersections (Medium)
     *
     * @see Solution1#merge(int[][])
     * @see Solution1#merge(int[], int, int[], int)
     * @see Solution701#employeeFreeTime(int)
     * @see <a href="https://leetcode-cn.com/problems/interval-list-intersections/">Interval List
     * Intersections</a>
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // todo
        return new int[0][0];
    }

    /**
     * 987. Vertical Order Traversal of a Binary Tree (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/">Vertical
     * Order Traversal of a Binary Tree</a>
     */
    public int[][] verticalTraversal(TreeNode root) {
        // todo
        return new int[0][0];
    }

    /**
     * 988. Smallest String Starting From Leaf (Medium)
     *
     * @see Solution101#sumNumbers(TreeNode)
     * @see Solution201#binaryTreePaths(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/">Smallest
     * String Starting From Leaf</a>
     */
    public String smallestFromLeaf(TreeNode root) {
        // todo
        return "";
    }

    /**
     * 989. Add to Array-Form of Integer (Easy)
     *
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1#plusOne(int[])
     * @see Solution1#addBinary(String, String)
     * @see Solution401#addStrings(String, String)
     * @see <a href="https://leetcode-cn.com/problems/add-to-array-form-of-integer/">Add to
     * Array-Form of Integer</a>
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>(num.length + 1);
        int i = num.length - 1, carry = 0;
        while (i >= 0 && k > 0) {
            int sum = num[i] + k % 10 + carry;
            res.add(sum % 10);
            carry = sum / 10;
            i--;
            k /= 10;
        }
        while (i >= 0) {
            int sum = num[i] + carry;
            res.add(sum % 10);
            carry = sum / 10;
            i--;
        }
        while (k > 0) {
            int sum = k % 10 + carry;
            res.add(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        if (carry == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 990. Satisfiability of Equality Equations (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/satisfiability-of-equality-equations/">Satisfiability
     * of Equality Equations</a>
     */
    public boolean equationsPossible(String[] equations) {
        // todo
        return false;
    }

    /**
     * 991. Broken Calculator (Medium)
     *
     * @see Solution601#minSteps(int)
     * @see <a href="https://leetcode-cn.com/problems/broken-calculator/">Broken Calculator</a>
     */
    public int brokenCalc(int x, int y) {
        // todo
        return 0;
    }

    /**
     * 992. Subarrays with K Different Integers (Hard)
     *
     * @see Solution1#lengthOfLongestSubstring(String)
     * @see Solution101#lengthOfLongestSubstringTwoDistinct(String)
     * @see Solution301#lengthOfLongestSubstringKDistinct(String, int)
     * @see <a href="https://leetcode-cn.com/problems/subarrays-with-k-different-integers/">Subarrays
     * with K Different Integers</a>
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 993. Cousins in Binary Tree (Easy)
     *
     * @see Solution101#levelOrder(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/cousins-in-binary-tree/">Cousins in Binary
     * Tree</a>
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] resX = findTarget(root, x, 0);
        int[] resY = findTarget(root, y, 0);
        return resX[0] == 1 && resY[0] == 1 && resX[1] == resY[1] && resX[2] != resY[2];
    }

    /**
     * @return [if found, depth of node, parent of node]
     */
    private int[] findTarget(TreeNode node, int target, int parent) {
        if (node.val == target) {
            return new int[]{1, 0, parent};
        }
        if (node.left != null) {
            int[] left = findTarget(node.left, target, node.val);
            if (left[0] == 1) {
                left[1]++;
                return left;
            }
        }
        if (node.right != null) {
            int[] right = findTarget(node.right, target, node.val);
            if (right[0] == 1) {
                right[1]++;
                return right;
            }
        }
        return new int[3];
    }

    /**
     * 994. Rotting Oranges (Medium)
     *
     * @see Solution201#wallsAndGates(int[][])
     * @see <a href="https://leetcode-cn.com/problems/rotting-oranges/">Rotting Oranges</a>
     */
    public int orangesRotting(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 995. Minimum Number of K Consecutive Bit Flips (Hard)
     *
     * @see Solution301#bulbSwitch(int)
     * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/">Minimum
     * Number of K Consecutive Bit Flips</a>
     */
    public int minKBitFlips(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 996. Number of Squareful Arrays (Hard)
     *
     * @see Solution1#permuteUnique(int[])
     * @see <a href="https://leetcode-cn.com/problems/number-of-squareful-arrays/">Number of
     * Squareful Arrays</a>
     */
    public int numSquarefulPerms(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 997. Find the Town Judge (Easy)
     *
     * @see Solution201#findCelebrity(int[][])
     * @see <a href="https://leetcode-cn.com/problems/find-the-town-judge/">Find the Town Judge</a>
     */
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];
        for (int[] entry : trust) {
            trusts[entry[0]]++;
            trusted[entry[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0) {
                return trusted[i] + 1 == n ? i : -1;
            }
        }
        return -1;
    }

    /**
     * 998. Maximum Binary Tree II (Medium)
     *
     * @see Solution601#constructMaximumBinaryTree(int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-binary-tree-ii/">Maximum Binary Tree
     * II</a>
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // todo
        return new TreeNode();
    }

    /**
     * 999. Available Captures for Rook (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/available-captures-for-rook/">Available
     * Captures for Rook</a>
     */
    public int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        boolean found = false;
        while (x < 8) {
            y = 0;
            while (y < 8) {
                if (board[x][y] == 'R') {
                    found = true;
                    break;
                }
                y++;
            }
            if (found) {
                break;
            }
            x++;
        }
        int res = 0;
        int i = x;
        while (--i >= 0) {
            if (board[i][y] == 'p') {
                res++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        i = x;
        while (++i < 8) {
            if (board[i][y] == 'p') {
                res++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        int j = y;
        while (--j >= 0) {
            if (board[x][j] == 'p') {
                res++;
                break;
            } else if (board[x][j] == 'B') {
                break;
            }
        }
        j = y;
        while (++j < 8) {
            if (board[x][j] == 'p') {
                res++;
                break;
            } else if (board[x][j] == 'B') {
                break;
            }
        }
        return res;
    }

    /**
     * 1000. Minimum Cost to Merge Stones (Hard)
     *
     * @see Solution301#maxCoins(int[])
     * @see Solution1101#connectSticks(int[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-cost-to-merge-stones/">Minimum Cost to
     * Merge Stones</a>
     */
    public int mergeStones(int[] stones, int k) {
        // todo
        return 0;
    }
}