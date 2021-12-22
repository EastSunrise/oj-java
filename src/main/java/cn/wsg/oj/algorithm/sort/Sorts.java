package cn.wsg.oj.algorithm.sort;

import cn.wsg.oj.Complexity;
import java.util.Comparator;
import java.util.Random;

/**
 * Common sorting methods.
 *
 * @author Kingen
 */
public class Sorts {

    /**
     * Finds the kth smallest element from the array.
     *
     * @param k must be positive and not larger than the size of the array
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_LOG_N
     */
    public static <T extends Comparable<T>> T findKthSmallest(T[] ts, int k) {
        return findKthSmallest(ts, k, Comparable::compareTo);
    }

    /**
     * Finds the kth smallest element from the array.
     *
     * @param k must be positive and not larger than the size of the array
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_LOG_N
     */
    public static <T> T findKthSmallest(T[] ts, int k, Comparator<? super T> comp) {
        if (k < 1 || k > ts.length) {
            throw new ArrayIndexOutOfBoundsException(k);
        }
        return findKthSmallest(ts, k, 0, ts.length, comp);
    }

    private static <T> T findKthSmallest(T[] ts, int k, int fromIn, int toEx,
        Comparator<? super T> comp) {
        int pivot = new Random().nextInt(toEx - fromIn) + fromIn;
        swap(ts, pivot, fromIn);
        int low = fromIn + 1, high = toEx - 1;
        while (low <= high) {
            if (comp.compare(ts[low], ts[fromIn]) <= 0) {
                low++;
            } else if (comp.compare(ts[fromIn], ts[high]) < 0) {
                high--;
            } else {
                T tmp = ts[low];
                ts[low++] = ts[high];
                ts[high--] = tmp;
            }
        }
        swap(ts, fromIn, high);
        if (k == low) {
            return ts[high];
        }
        if (k < low) {
            return findKthSmallest(ts, k, fromIn, high, comp);
        }
        return findKthSmallest(ts, k, low, toEx, comp);
    }

    private static <T> void swap(T[] ts, int i, int j) {
        T tmp = ts[i];
        ts[i] = ts[j];
        ts[j] = tmp;
    }
}
