package wsg.oj.java.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kingen
 */
public class SortSolution {

    public static void main(String[] args) {
        SortSolution solution = new SortSolution();
        solution.intersect(new int[]{
                1, 2, 2, 1
        }, new int[]{
                2, 2
        });
    }

    private int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersect = new LinkedList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length)
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                intersect.add(nums1[i]);
                i++;
                j++;
            }
        int[] result = new int[intersect.size()];
        int k = 0;
        for (Integer val : intersect)
            result[k++] = val;
        return result;
    }

    // 922. 按奇偶排序数组 II
    public int[] sortArrayByParityII(int[] A) {
        int evenIndex = 0, oddIndex = 1;
        while (evenIndex < A.length && oddIndex < A.length)
            if (A[evenIndex] % 2 == 0)
                evenIndex += 2;
            else if (A[oddIndex] % 2 == 1)
                oddIndex += 2;
            else {
                A[evenIndex] += A[oddIndex];
                A[oddIndex] = A[evenIndex] - A[oddIndex];
                A[evenIndex] -= A[oddIndex];
                evenIndex += 2;
                oddIndex += 2;
            }
        return A;
    }
}
