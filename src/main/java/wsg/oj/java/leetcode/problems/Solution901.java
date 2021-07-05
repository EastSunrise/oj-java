package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.901-No.1000.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution901 extends Solution {

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
}