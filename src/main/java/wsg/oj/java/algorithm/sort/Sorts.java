package wsg.oj.java.algorithm.sort;

import java.util.Comparator;
import java.util.Random;

/**
 * Common sorting methods.
 *
 * @author Kingen
 * @since 2021/8/1
 */
public class Sorts {

    /**
     * Finds the kth smallest element from the array.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_LOG_N
     */
    public static <T> T findKthSmallest(T[] ts, int k, Comparator<? super T> comp) {
        return findKthSmallest(ts, k, 0, ts.length, comp);
    }

    private static <T> T findKthSmallest(T[] ts, int k, int fromIn, int toEx,
        Comparator<? super T> comp) {
        T pivot = ts[new Random().nextInt(toEx - fromIn) + fromIn];
        int left = fromIn, right = toEx - 1;
        while (left <= right) {
            if (comp.compare(ts[left], pivot) <= 0) {
                left++;
            } else if (comp.compare(pivot, ts[right]) < 0) {
                right--;
            } else {
                T tmp = ts[left];
                ts[left++] = ts[right];
                ts[right--] = tmp;
            }
        }
        int mid = fromIn;
        while (mid <= right) {
            if (comp.compare(ts[mid], pivot) == 0) {
                T tmp = ts[mid];
                ts[mid] = ts[right];
                ts[right--] = tmp;
            } else {
                mid++;
            }
        }
        if (k <= right) {
            return findKthSmallest(ts, k, fromIn, mid, comp);
        }
        if (k >= left) {
            return findKthSmallest(ts, k, left, toEx, comp);
        }
        return pivot;
    }
}
