package wsg.oj.java.leetcode.problems.old;

/**
 * @author Kingen
 */
public class ArraySolution {

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
