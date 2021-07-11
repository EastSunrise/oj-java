package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * Solutions to problems No.801-No.900.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution801 implements Solution {

    String[] morse = new String[]{
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
        "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."
    };

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
}