package wsg.oj.java.leetcode.problems.old;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kingen
 */
public class ArraySolution {

    // wsg 324. 摆动排序 II
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                int next = i;
                while (++next < nums.length && nums[i] == nums[next]) {
                }
                int temp = nums[i] > nums[next] ^ i % 2 == 0 ? i - 1 : i;
                nums[temp] += nums[next];
                nums[next] = nums[temp] - nums[next];
                nums[temp] -= nums[next];
            } else if ((i % 2 == 1 && nums[i - 1] > nums[i]) || (i % 2 == 0
                && nums[i - 1] < nums[i])) {
                nums[i] += nums[i - 1];
                nums[i - 1] = nums[i] - nums[i - 1];
                nums[i] -= nums[i - 1];
            }
        }
    }

    // 376. 摆动序列
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    // 474. 一和零
    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxForm(strs, strs.length - 1, m, n);
    }

    private int findMaxForm(String[] strs, int end, int m, int n) {
        if (end < 0) {
            return 0;
        }
        String last = strs[end];
        int count0 = 0;
        for (char c : last.toCharArray()) {
            if (c == '0') {
                count0++;
            }
        }
        int count1 = last.length() - count0;
        int noLast = findMaxForm(strs, end - 1, m, n);
        if (m < count0 || n < count1) {
            return noLast;
        }
        return Math.max(findMaxForm(strs, end - 1, m - count0, n - count1) + 1, noLast);
    }

    // 532. 数组中的K-diff数对
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (set.add(num)) {
                count++;
            }
        }
        if (k == 0) {
            return count;
        }
        Integer[] nums1 = set.toArray(new Integer[0]);
        Arrays.sort(nums1);
        for (Integer num : nums1) {
            if (set.contains(num + k)) {
                count++;
            }
        }
        return count;
    }

    // 581. 最短无序连续子数组
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int left = 0;
        while (left < len - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left == len - 1) {
            return 0;
        }
        int right = len - 1;
        while (right >= 1 && nums[right] >= nums[right - 1]) {
            right--;
        }
        int min = nums[right], max = nums[left];
        for (int i = left + 1; i < right; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        while (left >= 0 && nums[left] > min) {
            left--;
        }
        while (right < len && nums[right] < max) {
            right++;
        }
        return right - left - 1;
    }

    // 665. 非递减数列
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return true;
        }
        int index = 1;
        while (index < len && nums[index - 1] <= nums[index]) {
            index++;
        }
        if (index == len) {
            return true;
        }
        if (index > 1 && nums[index - 2] > nums[index] && index < len - 1 && nums[index - 1] > nums[
            index + 1]) {
            return false;
        }
        while (++index < len) {
            if (nums[index - 1] > nums[index]) {
                return false;
            }
        }
        return true;
    }

    // 849. 到最近的人的最大距离
    private int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int first = -1, last = len;
        while (++first < len && seats[first] == 0) {
        }
        while (--last >= 0 && seats[last] == 0) {
        }
        int max = Math.max(first, len - 1 - last);
        while (first < last) {
            int next = first;
            while (seats[++next] == 0) {
            }
            int dist = (next - first) >> 1;
            if (dist > max) {
                max = dist;
            }
            first = next;
        }
        return max;
    }
}
