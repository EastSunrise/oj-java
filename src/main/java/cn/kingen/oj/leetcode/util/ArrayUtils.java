package cn.kingen.oj.leetcode.util;

import java.util.*;
import java.util.function.Function;

/**
 * @author Kingen
 **/
public final class ArrayUtils {

    public static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static final int[][] EIGHT_DIRECTIONS = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    /**
     * Finds elements that appear more than [n/m] times.
     * <p>
     * Moore Voting: if x is a majority that appears more than [n/m] times, it's still a majority
     * after removing m different elements from the array.
     */
    public static List<Integer> findMajorityElements(int[] nums, int m) {
        // candidates of majorities
        Map<Integer, Integer> majorities = new HashMap<>(m - 1);
        for (int num : nums) {
            Integer cnt = majorities.get(num);
            if (cnt != null) {
                // count++ if exists
                majorities.put(num, cnt + 1);
            } else if (majorities.size() < m - 1) {
                // add a new majority
                majorities.put(num, 1);
            } else { // nullify m different numbers
                Iterator<Map.Entry<Integer, Integer>> iterator = majorities.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    if (entry.getValue() == 1) {
                        iterator.remove();
                    } else {
                        majorities.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
            }
        }
        // check whether a candidate is truly a majority
        List<Integer> ans = new ArrayList<>();
        int target = nums.length / m;
        for (int majority : majorities.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (num == majority) {
                    count++;
                }
            }
            if (count > target) {
                ans.add(majority);
            }
        }
        return ans;
    }

    /**
     * Calculates the inverted index of the array.
     */
    public static Map<Integer, List<Integer>> invertedIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
        }
        return map;
    }

    /**
     * Finds the k-th smallest element from the array.
     *
     * @param k 1-based index, must be positive and not larger than the size of the array
     */
    public static int findKthSmallest(int[] ts, int k) {
        if (k < 1 || k > ts.length) {
            throw new ArrayIndexOutOfBoundsException(k);
        }
        return findKthSmallest(ts, k, 0, ts.length - 1);
    }

    public static int findKthSmallest(int[] ts, int k, int from, int to) {
        swap(ts, to, from + (int) (Math.random() * (to - from + 1)));
        int pivot = ts[to];
        int i = from;
        for (int j = from; j < to; j++) {
            if (ts[j] < pivot) {
                swap(ts, i++, j);
            }
        }
        swap(ts, i, to);
        if (k - 1 == i) {
            return ts[i];
        }
        if (k - 1 < i) {
            return findKthSmallest(ts, k, from, i - 1);
        }
        return findKthSmallest(ts, k, i + 1, to);
    }

    /**
     * Swaps two elements in an array.
     */
    public static void swap(int[] ts, int i, int j) {
        int tmp = ts[i];
        ts[i] = ts[j];
        ts[j] = tmp;
    }

    /**
     * Finds the k-th smallest element from the array.
     *
     * @param k 1-based index, must be positive and not larger than the size of the array
     */
    public static <T> T findKthSmallest(T[] ts, int k, Comparator<? super T> comp) {
        if (k < 1 || k > ts.length) {
            throw new ArrayIndexOutOfBoundsException(k);
        }
        return findKthSmallest(ts, k, 0, ts.length - 1, comp);
    }

    private static <T> T findKthSmallest(T[] ts, int k, int from, int to, Comparator<? super T> comp) {
        swap(ts, to, from + (int) (Math.random() * (to - from + 1)));
        T pivot = ts[to];
        int i = from;
        for (int j = from; j < to; j++) {
            if (comp.compare(ts[i], pivot) < 0) {
                swap(ts, i++, j);
            }
        }
        swap(ts, i, to);
        if (k - 1 == i) {
            return ts[i];
        }
        if (k - 1 < i) {
            return findKthSmallest(ts, k, from, i - 1, comp);
        }
        return findKthSmallest(ts, k, i + 1, to, comp);
    }

    /**
     * Longest increasing subsequence.
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        // dp[i]: the min of the last numbers of increasing subsequences with the length of i
        int[] dp = new int[n];
        int size = 0;
        for (int num : nums) {
            int j = Arrays.binarySearch(dp, 0, size, num);
            if (j < 0) {
                j = -j - 1;
            }
            dp[j] = num;
            if (j == size) {
                size++;
            }
        }
        return size;
    }

    /**
     * Searches the specified list for the specified object using the binary search algorithm.
     */
    public static <T> int binarySearch(List<T> list, Function<T, Integer> comparator) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = comparator.apply(midVal);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    /**
     * Swaps two elements in an array.
     */
    public static <T> void swap(T[] ts, int i, int j) {
        T tmp = ts[i];
        ts[i] = ts[j];
        ts[j] = tmp;
    }
}
