package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Solutions to problems No.801-No.900.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution801 extends Solution {

    String[] morse = new String[]{
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
        "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."
    };

    /**
     * 801. Minimum Swaps To Make Sequences Increasing (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/">Minimum
     * Swaps To Make Sequences Increasing</a>
     */
    public int minSwap(int[] nums1, int[] nums2) {
        // todo
        return 0;
    }

    /**
     * 802. Find Eventual Safe States (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-eventual-safe-states/">Find Eventual Safe
     * States</a>
     */
    public int[] eventualSafeNodes(int[][] graph) {
        // todo
        return new int[0];
    }

    /**
     * 803. Bricks Falling When Hit (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/bricks-falling-when-hit/">Bricks Falling When
     * Hit</a>
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        // todo
        return new int[0];
    }

    /**
     * 804. Unique Morse Code Words (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/unique-morse-code-words/">Unique Morse Code
     * Words</a>
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                builder.append(morse[ch - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

    /**
     * 805. Split Array With Same Average (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/split-array-with-same-average/">Split Array
     * With Same Average</a>
     */
    public boolean splitArraySameAverage(int[] nums) {
        // todo
        return false;
    }

    /**
     * 806. Number of Lines To Write String (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-of-lines-to-write-string/">Number of
     * Lines To Write String</a>
     */
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1, column = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            column += width;
            if (column > 100) {
                column = width;
                line++;
            }
        }
        return new int[]{line, column};
    }

    /**
     * 807. Max Increase to Keep City Skyline (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/">Max
     * Increase to Keep City Skyline</a>
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 808. Soup Servings (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/soup-servings/">Soup Servings</a>
     */
    public double soupServings(int n) {
        // todo
        return 0.0;
    }

    /**
     * 809. Expressive Words (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/expressive-words/">Expressive Words</a>
     */
    public int expressiveWords(String s, String[] words) {
        // todo
        return 0;
    }

    /**
     * 810. Chalkboard XOR Game (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/chalkboard-xor-game/">Chalkboard XOR Game</a>
     */
    public boolean xorGame(int[] nums) {
        // todo
        return false;
    }

    /**
     * 811. Subdomain Visit Count (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/subdomain-visit-count/">Subdomain Visit
     * Count</a>
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>(cpdomains.length);
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            String domain = parts[1];
            int count = Integer.parseInt(parts[0]);
            while (true) {
                int old = counts.getOrDefault(domain, 0);
                counts.put(domain, old + count);
                int idx = domain.indexOf('.');
                if (idx < 0) {
                    break;
                }
                domain = domain.substring(idx + 1);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    /**
     * 812. Largest Triangle Area (Easy)
     *
     * @see Solution901#largestPerimeter(int[])
     * @see <a href="https://leetcode-cn.com/problems/largest-triangle-area/">Largest Triangle
     * Area</a>
     */
    public double largestTriangleArea(int[][] points) {
        // todo
        return 0.0;
    }

    /**
     * 813. Largest Sum of Averages (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-sum-of-averages/">Largest Sum of
     * Averages</a>
     */
    public double largestSumOfAverages(int[] nums, int k) {
        // todo
        return 0.0;
    }

    /**
     * 814. Binary Tree Pruning (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-pruning/">Binary Tree Pruning</a>
     */
    public TreeNode pruneTree(TreeNode root) {
        // todo
        return new TreeNode();
    }

    /**
     * 815. Bus Routes (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/bus-routes/">Bus Routes</a>
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // todo
        return 0;
    }

    /**
     * 816. Ambiguous Coordinates (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/ambiguous-coordinates/">Ambiguous
     * Coordinates</a>
     */
    public String[] ambiguousCoordinates(String s) {
        // todo
        return new String[0];
    }

    /**
     * 817. Linked List Components (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/linked-list-components/">Linked List
     * Components</a>
     */
    public int numComponents(ListNode head, int[] nums) {
        // todo
        return 0;
    }

    /**
     * 818. Race Car (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/race-car/">Race Car</a>
     */
    public int racecar(int target) {
        // todo
        return 0;
    }

    /**
     * 819. Most Common Word (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/most-common-word/">Most Common Word</a>
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> counts = new HashMap<>(4);
        Set<String> bans = new HashSet<>(Arrays.asList(banned));
        int maxCount = 0;
        String res = null;
        StringBuilder builder = new StringBuilder();
        for (char ch : (paragraph + " ").toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                builder.append((char) (ch + 32));
            } else if (ch >= 'a' && ch <= 'z') {
                builder.append(ch);
            } else if (builder.length() > 0) {
                String word = builder.toString();
                if (!bans.contains(word)) {
                    int count = counts.getOrDefault(word, 0) + 1;
                    if (count > maxCount) {
                        maxCount = count;
                        res = word;
                    }
                    counts.put(word, count);
                }
                builder = new StringBuilder();
            }
        }
        return res;
    }

    /**
     * 820. Short Encoding of Words (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/short-encoding-of-words/">Short Encoding of
     * Words</a>
     */
    public int minimumLengthEncoding(String[] words) {
        // todo
        return 0;
    }

    /**
     * 821. Shortest Distance to a Character (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-distance-to-a-character/">Shortest
     * Distance to a Character</a>
     */
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] distances = new int[len];
        for (int i = 0; i < len; i++) {
            if (c == s.charAt(i)) {
                distances[i] = -1;
            }
        }
        int start = 0;
        // the first part
        while (start < len && s.charAt(start) != c) {
            start++;
        }
        for (int i = 0; i < start; i++) {
            distances[i] = start - i;
        }
        // the last part
        int tail = len - 1;
        while (tail >= 0 && s.charAt(tail) != c) {
            tail--;
        }
        for (int i = tail; i < len; i++) {
            distances[i] = i - tail;
        }
        // the middle parts
        while (true) {
            do {
                distances[start] = 0;
                start++;
            } while (start < tail && s.charAt(start) == c);
            if (start >= tail) {
                break;
            }
            int end = start + 1;
            while (s.charAt(end) != c) {
                end++;
            }
            int left = start, right = end - 1, dist = 1;
            while (left <= right) {
                distances[left++] = dist;
                distances[right--] = dist;
                dist++;
            }
            start = end;
        }
        return distances;
    }

    /**
     * 822. Card Flipping Game (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/card-flipping-game/">Card Flipping Game</a>
     */
    public int flipgame(int[] fronts, int[] backs) {
        // todo
        return 0;
    }

    /**
     * 823. Binary Trees With Factors (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/binary-trees-with-factors/">Binary Trees With
     * Factors</a>
     */
    public int numFactoredBinaryTrees(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 824. Goat Latin (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/goat-latin/">Goat Latin</a>
     */
    public String toGoatLatin(String sentence) {
        StringBuilder builder = new StringBuilder(sentence.length());
        int initial = 0, number = 1;
        for (char ch : (sentence + " ").toCharArray()) {
            if (ch == ' ') {
                char first = builder.charAt(initial);
                if (notVowel(first)) {
                    builder.deleteCharAt(initial);
                    builder.append(first);
                }
                builder.append("ma");
                builder.append("a".repeat(number++));
                builder.append(' ');
                initial = builder.length();
            } else {
                builder.append(ch);
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private boolean notVowel(char ch) {
        if (ch > 'U') {
            ch -= 32;
        }
        return ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }

    /**
     * 825. Friends Of Appropriate Ages (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/friends-of-appropriate-ages/">Friends Of
     * Appropriate Ages</a>
     */
    public int numFriendRequests(int[] ages) {
        // todo
        return 0;
    }

    /**
     * 826. Most Profit Assigning Work (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/most-profit-assigning-work/">Most Profit
     * Assigning Work</a>
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // todo
        return 0;
    }

    /**
     * 827. Making A Large Island (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/making-a-large-island/">Making A Large
     * Island</a>
     */
    public int largestIsland(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 828. Count Unique Characters of All Substrings of a Given String (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/">Count
     * Unique Characters of All Substrings of a Given String</a>
     */
    public int uniqueLetterString(String s) {
        // todo
        return 0;
    }

    /**
     * 829. Consecutive Numbers Sum (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/consecutive-numbers-sum/">Consecutive Numbers
     * Sum</a>
     */
    public int consecutiveNumbersSum(int n) {
        // todo
        return 0;
    }

    /**
     * 830. Positions of Large Groups (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/positions-of-large-groups/">Positions of Large
     * Groups</a>
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        while (start < len) {
            char ch = chars[start];
            int end = start + 1;
            while (end < len && chars[end] == ch) {
                end++;
            }
            if (end - start >= 3) {
                res.add(Arrays.asList(start, end - 1));
            }
            start = end;
        }
        return res;
    }

    /**
     * 831. Masking Personal Information (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/masking-personal-information/">Masking
     * Personal Information</a>
     */
    public String maskPII(String s) {
        // todo
        return "";
    }

    /**
     * 832. Flipping an Image (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/flipping-an-image/">Flipping an Image</a>
     */
    public int[][] flipAndInvertImage(int[][] image) {
        // todo
        return new int[0][0];
    }

    /**
     * 833. Find And Replace in String (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-and-replace-in-string/">Find And Replace
     * in String</a>
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // todo
        return "";
    }

    /**
     * 834. Sum of Distances in Tree (Hard)
     *
     * @see Solution901#distributeCoins(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/sum-of-distances-in-tree/">Sum of Distances in
     * Tree</a>
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // todo
        return new int[0];
    }

    /**
     * 835. Image Overlap (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/image-overlap/">Image Overlap</a>
     */
    public int largestOverlap(int[][] img1, int[][] img2) {
        // todo
        return 0;
    }

    /**
     * 836. Rectangle Overlap (Easy)
     *
     * @see Solution201#computeArea(int, int, int, int, int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/rectangle-overlap/">Rectangle Overlap</a>
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // valid rectangle
        return rec1[0] < rec1[2] && rec1[1] < rec1[3] && rec2[0] < rec2[2] && rec2[1] < rec2[3] &&
            rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1];
    }

    /**
     * 837. New 21 Game (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/new-21-game/">New 21 Game</a>
     */
    public double new21Game(int n, int k, int maxPts) {
        // todo
        return 0.0;
    }

    /**
     * 838. Push Dominoes (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/push-dominoes/">Push Dominoes</a>
     */
    public String pushDominoes(String dominoes) {
        // todo
        return "";
    }

    /**
     * 839. Similar String Groups (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/similar-string-groups/">Similar String
     * Groups</a>
     */
    public int numSimilarGroups(String[] strs) {
        // todo
        return 0;
    }

    /**
     * 840. Magic Squares In Grid (Medium)
     *
     * @see Solution1801#largestMagicSquare(int[][])
     * @see <a href="https://leetcode-cn.com/problems/magic-squares-in-grid/">Magic Squares In
     * Grid</a>
     */
    public int numMagicSquaresInside(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 841. Keys and Rooms (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/keys-and-rooms/">Keys and Rooms</a>
     */
    public boolean canVisitAllRooms(int[][] rooms) {
        // todo
        return false;
    }

    /**
     * 842. Split Array into Fibonacci Sequence (Medium)
     *
     * @see Solution301#isAdditiveNumber(String)
     * @see Solution501#fib(int)
     * @see <a href="https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/">Split
     * Array into Fibonacci Sequence</a>
     */
    public int[] splitIntoFibonacci(String num) {
        // todo
        return new int[0];
    }

    /**
     * 843. Guess the Word (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/guess-the-word/">Guess the Word</a>
     */
    public void findSecretWord(String secret, String[] wordlist, int numguesses) {
        // todo
    }

    /**
     * 844. Backspace String Compare (Easy)
     *
     * @see Solution1501#minOperations(String[])
     * @see <a href="https://leetcode-cn.com/problems/backspace-string-compare/">Backspace String
     * Compare</a>
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = type(s);
        Stack<Character> ts = type(t);
        if (ss.size() != ts.size()) {
            return false;
        }
        while (!ss.isEmpty()) {
            if (!ss.pop().equals(ts.pop())) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> type(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack;
    }

    /**
     * 845. Longest Mountain in Array (Medium)
     *
     * @see Solution1601#minimumMountainRemovals(int[])
     * @see <a href="https://leetcode-cn.com/problems/longest-mountain-in-array/">Longest Mountain
     * in Array</a>
     */
    public int longestMountain(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 846. Hand of Straights (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/hand-of-straights/">Hand of Straights</a>
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // todo
        return false;
    }

    /**
     * 847. Shortest Path Visiting All Nodes (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/">Shortest
     * Path Visiting All Nodes</a>
     */
    public int shortestPathLength(int[][] graph) {
        // todo
        return 0;
    }

    /**
     * 848. Shifting Letters (Medium)
     *
     * @see Solution1801#replaceDigits(String)
     * @see <a href="https://leetcode-cn.com/problems/shifting-letters/">Shifting Letters</a>
     */
    public String shiftingLetters(String s, int[] shifts) {
        // todo
        return "";
    }

    /**
     * 849. Maximize Distance to Closest Person (Medium)
     *
     * @see ExamRoom
     * @see <a href="https://leetcode-cn.com/problems/maximize-distance-to-closest-person/">Maximize
     * Distance to Closest Person</a>
     */
    public int maxDistToClosest(int[] seats) {
        // todo
        return 0;
    }

    /**
     * 850. Rectangle Area II (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/rectangle-area-ii/">Rectangle Area II</a>
     */
    public int rectangleArea(int[][] rectangles) {
        // todo
        return 0;
    }

    /**
     * 851. Loud and Rich (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/loud-and-rich/">Loud and Rich</a>
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // todo
        return new int[0];
    }

    /**
     * 852. Peak Index in a Mountain Array (Easy)
     *
     * @see Solution101#findPeakElement(int[])
     * @see Solution901#validMountainArray(int[])
     * @see Solution1001#findInMountainArray(int[], int)
     * @see Solution1601#minimumMountainRemovals(int[])
     * @see <a href="https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/">Peak Index in
     * a Mountain Array</a>
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 853. Car Fleet (Medium)
     *
     * @see Solution1701#getCollisionTimes(int[][])
     * @see <a href="https://leetcode-cn.com/problems/car-fleet/">Car Fleet</a>
     */
    public int carFleet(int target, int[] position, int[] speed) {
        // todo
        return 0;
    }

    /**
     * 854. K-Similar Strings (Hard)
     *
     * @see Solution701#minSwapsCouples(int[])
     * @see <a href="https://leetcode-cn.com/problems/k-similar-strings/">K-Similar Strings</a>
     */
    public int kSimilarity(String s1, String s2) {
        // todo
        return 0;
    }


    /**
     * 856. Score of Parentheses (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/score-of-parentheses/">Score of
     * Parentheses</a>
     */
    public int scoreOfParentheses(String s) {
        // todo
        return 0;
    }

    /**
     * 857. Minimum Cost to Hire K Workers (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers/">Minimum Cost
     * to Hire K Workers</a>
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // todo
        return 0.0;
    }

    /**
     * 858. Mirror Reflection (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/mirror-reflection/">Mirror Reflection</a>
     */
    public int mirrorReflection(int p, int q) {
        // todo
        return 0;
    }

    /**
     * 859. Buddy Strings (Easy)
     *
     * @see Solution1601#closeStrings(String, String)
     * @see Solution1701#areAlmostEqual(String, String)
     * @see <a href="https://leetcode-cn.com/problems/buddy-strings/">Buddy Strings</a>
     */
    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        int difCount = 0;
        int[] difIndices = new int[3];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                difIndices[difCount++] = i;
                if (difCount > 2) {
                    return false;
                }
            }
        }
        if (difCount == 0) {
            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) != i) {
                    return true;
                }
            }
            return false;
        }
        if (difCount == 1) {
            return false;
        }
        int i = difIndices[0], j = difIndices[1];
        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }

    /**
     * 860. Lemonade Change (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/lemonade-change/">Lemonade Change</a>
     */
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else {
                if (bill == 10) {
                    count10++;
                    count5--;
                } else if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
                if (count5 < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 861. Score After Flipping Matrix (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/score-after-flipping-matrix/">Score After
     * Flipping Matrix</a>
     */
    public int matrixScore(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 862. Shortest Subarray with Sum at Least K (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/">Shortest
     * Subarray with Sum at Least K</a>
     */
    public int shortestSubarray(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 863. All Nodes Distance K in Binary Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/">All
     * Nodes Distance K in Binary Tree</a>
     */
    public int[] distanceK(TreeNode root, int target, int k) {
        // todo
        return new int[0];
    }

    /**
     * 864. Shortest Path to Get All Keys (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-path-to-get-all-keys/">Shortest Path
     * to Get All Keys</a>
     */
    public int shortestPathAllKeys(String[] grid) {
        // todo
        return 0;
    }

    /**
     * 865. Smallest Subtree with all the Deepest Nodes (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/">Smallest
     * Subtree with all the Deepest Nodes</a>
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // todo
        return new TreeNode();
    }

    /**
     * 866. Prime Palindrome (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/prime-palindrome/">Prime Palindrome</a>
     */
    public int primePalindrome(int n) {
        // todo
        return 0;
    }

    /**
     * 867. Transpose Matrix (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/transpose-matrix/">Transpose Matrix</a>
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    /**
     * 868. Binary Gap (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/binary-gap/">Binary Gap</a>
     */
    public int binaryGap(int n) {
        // the last 1
        while (n > 0 && (n & 1) == 0) {
            n >>= 1;
        }
        n >>= 1;
        int max = 0, dist = 0;
        while (n > 0) {
            dist++;
            // when one appears
            if ((n & 1) == 1) {
                max = Math.max(max, dist);
                dist = 0;
            }
            n >>= 1;
        }
        return max;
    }

    /**
     * 869. Reordered Power of 2 (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/reordered-power-of-2/">Reordered Power of
     * 2</a>
     */
    public boolean reorderedPowerOf2(int n) {
        // todo
        return false;
    }

    /**
     * 870. Advantage Shuffle (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/advantage-shuffle/">Advantage Shuffle</a>
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // todo
        return new int[0];
    }

    /**
     * 871. Minimum Number of Refueling Stops (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-refueling-stops/">Minimum
     * Number of Refueling Stops</a>
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // todo
        return 0;
    }

    /**
     * 872. Leaf-Similar Trees (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/leaf-similar-trees/">Leaf-Similar Trees</a>
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (((int) leaves1.get(i)) != leaves2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
    }

    /**
     * 873. Length of Longest Fibonacci Subsequence (Medium)
     *
     * @see Solution501#fib(int)
     * @see <a href="https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/">Length
     * of Longest Fibonacci Subsequence</a>
     */
    public int lenLongestFibSubseq(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 874. Walking Robot Simulation (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/walking-robot-simulation/">Walking Robot
     * Simulation</a>
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>(obstacles.length);
        for (int[] obstacle : obstacles) {
            Set<Integer> ys = map.getOrDefault(obstacle[0], new HashSet<>());
            ys.add(obstacle[1]);
            map.put(obstacle[0], ys);
        }
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int max = 0;
        // direction: 0-N, 1-E, 2-S, 3-W
        int dir = 0, x = 0, y = 0;
        for (int cmd : commands) {
            if (cmd > 0) {
                for (int i = 0; i < cmd; i++) {
                    x += dx[dir];
                    y += dy[dir];
                    Set<Integer> ys = map.get(x);
                    if (ys != null && ys.contains(y)) {
                        x -= dx[dir];
                        y -= dy[dir];
                        break;
                    }
                }
                int dist = x * x + y * y;
                if (dist > max) {
                    max = dist;
                }
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {
                dir = (dir + 3) % 4;
            }
        }
        return max;
    }

    /**
     * 875. Koko Eating Bananas (Medium)
     *
     * @see Solution701#minmaxGasDist(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
     */
    public int minEatingSpeed(int[] piles, int h) {
        // todo
        return 0;
    }

    /**
     * 876. Middle of the Linked List (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list/">Middle of the
     * Linked List</a>
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 877. Stone Game (Medium)
     *
     * @see Solution1501#stoneGameV(int[])
     * @see Solution1601#stoneGameVI(int[], int[])
     * @see Solution1601#stoneGameVII(int[])
     * @see Solution1801#stoneGameVIII(int[])
     * @see <a href="https://leetcode-cn.com/problems/stone-game/">Stone Game</a>
     */
    public boolean stoneGame(int[] piles) {
        // todo
        return false;
    }

    /**
     * 878. Nth Magical Number (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/nth-magical-number/">Nth Magical Number</a>
     */
    public int nthMagicalNumber(int n, int a, int b) {
        // todo
        return 0;
    }

    /**
     * 879. Profitable Schemes (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/profitable-schemes/">Profitable Schemes</a>
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // todo
        return 0;
    }

    /**
     * 880. Decoded String at Index (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/decoded-string-at-index/">Decoded String at
     * Index</a>
     */
    public String decodeAtIndex(String s, int k) {
        // todo
        return "";
    }

    /**
     * 881. Boats to Save People (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/boats-to-save-people/">Boats to Save
     * People</a>
     */
    public int numRescueBoats(int[] people, int limit) {
        // todo
        return 0;
    }

    /**
     * 882. Reachable Nodes In Subdivided Graph (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/reachable-nodes-in-subdivided-graph/">Reachable
     * Nodes In Subdivided Graph</a>
     */
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // todo
        return 0;
    }

    /**
     * 883. Projection Area of 3D Shapes (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/projection-area-of-3d-shapes/">Projection Area
     * of 3D Shapes</a>
     */
    public int projectionArea(int[][] grid) {
        int vertical = 0;
        for (int[] yz : grid) {
            for (int z : yz) {
                if (z > 0) {
                    vertical++;
                }
            }
        }
        int main = 0;
        for (int[] yz : grid) {
            int max = 0;
            for (int z : yz) {
                max = Math.max(max, z);
            }
            main += max;
        }
        int left = 0;
        int n = grid.length;
        for (int y = 0; y < n; y++) {
            int max = 0;
            for (int[] yz : grid) {
                max = Math.max(max, yz[y]);
            }
            left += max;
        }
        return vertical + main + left;
    }

    /**
     * 884. Uncommon Words from Two Sentences (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/">Uncommon
     * Words from Two Sentences</a>
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> unique = new HashSet<>(), duplicate = new HashSet<>();
        for (String s : s1.split(" ")) {
            if (!unique.add(s)) {
                duplicate.add(s);
            }
        }
        for (String s : s2.split(" ")) {
            if (!unique.add(s)) {
                duplicate.add(s);
            }
        }
        unique.removeAll(duplicate);
        return unique.toArray(new String[0]);
    }

    /**
     * 885. Spiral Matrix III (Medium)
     *
     * @see Solution1#spiralOrder(int[][])
     * @see Solution1#generateMatrix(int)
     * @see <a href="https://leetcode-cn.com/problems/spiral-matrix-iii/">Spiral Matrix III</a>
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // todo
        return new int[0][0];
    }

    /**
     * 886. Possible Bipartition (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/possible-bipartition/">Possible
     * Bipartition</a>
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // todo
        return false;
    }

    /**
     * 887. Super Egg Drop (Hard)
     *
     * @see Solution1801#twoEggDrop(int)
     * @see <a href="https://leetcode-cn.com/problems/super-egg-drop/">Super Egg Drop</a>
     */
    public int superEggDrop(int k, int n) {
        // todo
        return 0;
    }

    /**
     * 888. Fair Candy Swap (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/fair-candy-swap/">Fair Candy Swap</a>
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int dif = 0;
        for (int a : aliceSizes) {
            dif += a;
        }
        for (int b : bobSizes) {
            dif -= b;
        }
        dif /= 2;
        Set<Integer> bobs = new HashSet<>(bobSizes.length);
        for (int bobSize : bobSizes) {
            bobs.add(bobSize);
        }
        for (int aliceSize : aliceSizes) {
            int target = aliceSize - dif;
            if (target > 0 && bobs.contains(target)) {
                return new int[]{aliceSize, target};
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    /**
     * 889. Construct Binary Tree from Preorder and Postorder Traversal (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/">Construct
     * Binary Tree from Preorder and Postorder Traversal</a>
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // todo
        return new TreeNode();
    }

    /**
     * 890. Find and Replace Pattern (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-and-replace-pattern/">Find and Replace
     * Pattern</a>
     */
    public String[] findAndReplacePattern(String[] words, String pattern) {
        // todo
        return new String[0];
    }

    /**
     * 891. Sum of Subsequence Widths (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/sum-of-subsequence-widths/">Sum of Subsequence
     * Widths</a>
     */
    public int sumSubseqWidths(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 892. Surface Area of 3D Shapes (Easy)
     *
     * @see Solution801#projectionArea(int[][])
     * @see <a href="https://leetcode-cn.com/problems/surface-area-of-3d-shapes/">Surface Area of 3D
     * Shapes</a>
     */
    public int surfaceArea(int[][] grid) {
        int vertical = 0;
        for (int[] yz : grid) {
            for (int z : yz) {
                if (z > 0) {
                    vertical += 2;
                }
            }
        }
        int n = grid.length;
        int main = 0;
        for (int x = 0; x < n; x++) {
            main += grid[x][0];
            for (int y = 1; y < n; y++) {
                main += Math.abs(grid[x][y] - grid[x][y - 1]);
            }
            main += grid[x][n - 1];
        }
        int left = 0;
        for (int y = 0; y < n; y++) {
            left += grid[0][y];
            for (int x = 1; x < n; x++) {
                main += Math.abs(grid[x][y] - grid[x - 1][y]);
            }
            left += grid[n - 1][y];
        }
        return vertical + main + left;
    }

    /**
     * 893. Groups of Special-Equivalent Strings (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/">Groups
     * of Special-Equivalent Strings</a>
     */
    public int numSpecialEquivGroups(String[] words) {
        Set<String> group = new HashSet<>();
        for (String word : words) {
            char[] even = new char[(word.length() + 1) / 2];
            for (int i = 0; i < word.length(); i += 2) {
                even[i / 2] = word.charAt(i);
            }
            char[] odd = new char[word.length() / 2];
            for (int i = 1; i < word.length(); i += 2) {
                odd[i / 2] = word.charAt(i);
            }
            Arrays.sort(even);
            Arrays.sort(odd);
            group.add(new String(even) + new String(odd));
        }
        return group.size();
    }

    /**
     * 894. All Possible Full Binary Trees (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/all-possible-full-binary-trees/">All Possible
     * Full Binary Trees</a>
     */
    public TreeNode[] allPossibleFBT(int n) {
        // todo
        return new TreeNode[0];
    }


    /**
     * 896. Monotonic Array (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/monotonic-array/">Monotonic Array</a>
     */
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        int i = 1;
        while (i < len && nums[i] >= nums[i - 1]) {
            i++;
        }
        if (i == len) {
            return true;
        }
        i = 1;
        while (i < len && nums[i] <= nums[i - 1]) {
            i++;
        }
        return i == len;
    }

    /**
     * 897. Increasing Order Search Tree (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">Increasing
     * Order Search Tree</a>
     */
    public TreeNode increasingBST(TreeNode root) {
        return convert(root)[0];
    }

    /**
     * Converts the bst to increasing bst
     *
     * @return [head node, tail node]
     */
    private TreeNode[] convert(TreeNode node) {
        TreeNode head = node, tail = node;
        if (node.left != null) {
            TreeNode[] left = convert(node.left);
            left[1].right = node;
            node.left = null;
            head = left[0];
        }
        if (node.right != null) {
            TreeNode[] right = convert(node.right);
            node.right = right[0];
            tail = right[1];
        }
        return new TreeNode[]{head, tail};
    }

    /**
     * 898. Bitwise ORs of Subarrays (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/">Bitwise ORs of
     * Subarrays</a>
     */
    public int subarrayBitwiseORs(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 899. Orderly Queue (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/orderly-queue/">Orderly Queue</a>
     */
    public String orderlyQueue(String s, int k) {
        // todo
        return "";
    }

}