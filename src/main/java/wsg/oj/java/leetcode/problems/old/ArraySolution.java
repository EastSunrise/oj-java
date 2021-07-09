package wsg.oj.java.leetcode.problems.old;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kingen
 */
public class ArraySolution {

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
