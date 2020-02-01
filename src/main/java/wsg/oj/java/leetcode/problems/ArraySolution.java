package wsg.oj.java.leetcode.problems;

import java.util.*;

/**
 * @author Kingen
 */
public class ArraySolution {
    public int removeDuplicates(int[] nums) {
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[lastIndex])
                nums[++lastIndex] = nums[i];
        return lastIndex + 1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0)
            nums1[index--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        while (n >= 0)
            nums1[index--] = nums2[n--];
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0)
            return list;
        while (list.size() < rowIndex + 1) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int i = 1; i < list.size(); i++) {
                cur.add(list.get(i - 1) + list.get(i));
            }
            cur.add(1);
            list = cur;
        }
        return list;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int maxProfit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++)
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - min;
                min = prices[i];
            }
        profit += prices[prices.length - 1] - min;
        return profit;
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2)
            return null;
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if (sum < target)
                index1++;
            else if (sum > target)
                index2--;
            else
                return new int[]{index1 + 1, index2 + 1};
        }
        return null;
    }

    // 189. 旋转数组
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1)
            return;
        k = len - k % len;
        for (int mod = 0; mod < k; mod++) {
            int temp = nums[mod];
            for (int i = mod; i < len - k; i += k)
                nums[i] = nums[i + k];
            nums[len - 1 - mod] = temp;
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> num2FirstIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer oldValue = num2FirstIndexMap.put(nums[i], i);
            if (oldValue != null && i - oldValue <= k)
                return true;
        }
        return false;
    }

    // 448. 找到所有数组中消失的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = -nums[i];
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                res.add(i + 1);
        }
        return res;
    }

    // 485. 最大连续1的个数
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums)
            if (num == 1)
                count++;
            else {
                if (count > max)
                    max = count;
                count = 0;
            }
        return count > max ? count : max;
    }

    // 532. 数组中的K-diff数对
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums)
            if (set.add(num))
                count++;
        if (k == 0)
            return count;
        Integer[] nums1 = set.toArray(new Integer[0]);
        Arrays.sort(nums1);
        for (Integer num : nums1)
            if (set.contains(num + k))
                count++;
        return count;
    }

    // 561. 数组拆分 I
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }

    // 566. 重塑矩阵
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row, col;
        if ((row = nums.length) == 0 || (col = nums[0].length) == 0 || row * col != r * c)
            return nums;
        int count = 0;
        int[][] res = new int[r][c];
        for (int[] ints : nums)
            for (int num : ints)
                res[count / c][count++ % c] = num;
        return res;
    }

    // 581. 最短无序连续子数组
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return 0;
        int left = 0;
        while (left < len - 1 && nums[left] <= nums[left + 1])
            left++;
        if (left == len - 1)
            return 0;
        int right = len - 1;
        while (right >= 1 && nums[right] >= nums[right - 1])
            right--;
        int min = nums[right], max = nums[left];
        for (int i = left + 1; i < right; i++)
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i] > max)
                max = nums[i];
        while (left >= 0 && nums[left] > min)
            left--;
        while (right < len && nums[right] < max)
            right++;
        return right - left - 1;
    }

    // 605. 种花问题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 0)
            return n == 0;
        BitSet bitSet = new BitSet(len);
        for (int i = 0; i < len; i++)
            if (flowerbed[i] == 1)
                bitSet.set(i);
        int lastOne = -1, count = 0;
        while (lastOne < len) {
            int curOne = bitSet.nextSetBit(lastOne + 1);
            if (curOne == -1)
                curOne = len;
            int countZero = curOne - lastOne - 1;
            if (countZero > 0)
                if (lastOne == -1 && curOne == len)
                    count += ++countZero >> 1;
                else if (lastOne != -1 && curOne != len)
                    count += countZero > 2 ? --countZero >> 1 : 0;
                else
                    count += countZero >> 1;
            lastOne = curOne;
        }
        return n <= count;
    }

    // 665. 非递减数列
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return true;
        int index = 1;
        while (index < len && nums[index - 1] <= nums[index])
            index++;
        if (index == len)
            return true;
        if (index > 1 && nums[index - 2] > nums[index] && index < len - 1 && nums[index - 1] > nums[index + 1])
            return false;
        while (++index < len)
            if (nums[index - 1] > nums[index])
                return false;
        return true;
    }

    // 697. 数组的度
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new int[]{1, i, i});
            else {
                int[] param = map.get(nums[i]);
                param[0]++;
                param[2] = i;
            }
        Collection<int[]> collection = map.values();
        int maxFre = 0, minLen = nums.length;
        for (int[] ints : collection)
            if (ints[0] > maxFre) {
                maxFre = ints[0];
                minLen = ints[2] - ints[1];
            } else if (ints[0] == maxFre) {
                int len = ints[2] - ints[1];
                if (len < minLen)
                    minLen = len;
            }
        return minLen + 1;
    }

    // 746. 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] sum = new int[len + 1];
        sum[0] = cost[0];
        sum[1] = cost[1];
        for (int i = 2; i < len; i++)
            sum[i] = Math.min(sum[i - 2] + cost[i], sum[i - 1]);
        return Math.min(sum[len - 2], sum[len - 1]);
    }

    // 941. 有效的山脉数组
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        int index = 1;
        while (index < A.length && A[index] > A[index - 1])
            index++;
        if (index == 1 || index == A.length)
            return false;
        while (index < A.length && A[index] < A[index - 1])
            index++;
        return index == A.length;
    }

    // 905. 按奇偶排序数组
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 == 0)
                left++;
            else if (A[right] % 2 == 1)
                right--;
            else {
                int temp = A[left];
                A[left++] = A[right];
                A[right--] = temp;
            }
        }
        return A;
    }

    // 896. 单调数列
    public boolean isMonotonic(int[] A) {
        int index = 0;
        while (++index < A.length && A[index] >= A[index - 1]) ;
        if (index == A.length)
            return true;
        index = 0;
        while (++index < A.length && A[index] <= A[index - 1]) ;
        return index == A.length;
    }

    // 849. 到最近的人的最大距离
    private int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int first = -1, last = len;
        while (++first < len && seats[first] == 0) ;
        while (--last >= 0 && seats[last] == 0) ;
        int max = Math.max(first, len - 1 - last);
        while (first < last) {
            int next = first;
            while (seats[++next] == 0) ;
            int dist = (next - first) >> 1;
            if (dist > max)
                max = dist;
            first = next;
        }
        return max;
    }

    // 747. 至少是其他数字两倍的最大数
    public int dominantIndex(int[] nums) {
        int index = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] * 2 > max && i != index)
                return -1;
        return index;
    }

    // 830. 较大分组的位置
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] chars = S.toCharArray();
        int first = 1;
        List<List<Integer>> listList = new ArrayList<>();
        while (first < chars.length)
            if (chars[first] != chars[first - 1])
                first++;
            else {
                int last = first;
                char c = chars[first];
                while (++last < chars.length && chars[last] == c) ;
                int count = last - first + 1;
                if (count >= 3)
                    listList.add(Arrays.asList(first - 1, last - 1));
                first = last + 1;
            }
        return listList;
    }

    // 674. 最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int index = 0, max = 1;
        while (index < nums.length) {
            int first = index;
            while (++index < nums.length && nums[index] > nums[index - 1]) ;
            int len = index - first;
            if (len > max)
                max = len;
        }
        return max;
    }

    // 724. 寻找数组的中心索引
    private int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int sumLeft = 0, sumRight = 0;
        for (int i = 1; i < nums.length; i++)
            sumRight += nums[i];
        int index = 0;
        int maxIndex = nums.length - 1;
        while (index < maxIndex && sumLeft != sumRight) {
            sumLeft += nums[index++];
            sumRight -= nums[index];
        }
        if (sumLeft == sumRight)
            return index;
        return -1;
    }

    // 506. 相对名次
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        String[] res = new String[map.size()];
        int rank = nums.length;
        for (Integer index : map.values()) {
            if (rank > 3)
                res[index] = String.valueOf(rank);
            else switch (rank) {
                case 1:
                    res[index] = "Gold Medal";
                    break;
                case 2:
                    res[index] = "Silver Medal";
                    break;
                case 3:
                    res[index] = "Bronze Medal";
                    break;
            }
            rank--;
        }
        return res;
    }

    // 520. 检测大写字母
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]([a-z]*|[A-Z]*)|[a-z]*");
    }

    // 888. 公平的糖果交换
    public int[] fairCandySwap(int[] A, int[] B) {
        int target = 0;
        for (int a : A) target += a;
        for (int b : B) target -= b;
        target >>= 1;
        Arrays.sort(A);
        Arrays.sort(B);
        int aIndex = 0, bIndex = 0;
        while (aIndex < A.length && bIndex < B.length) {
            int dif = A[aIndex] - B[bIndex];
            if (dif < target)
                aIndex++;
            else if (dif > target)
                bIndex++;
            else
                return new int[]{A[aIndex], B[bIndex]};
        }
        return null;
    }

    // 11. 盛最多水的容器
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            int hl = height[l], hr = height[r];
            if (hl < hr) {
                l++;
                if (height[l] > hl) {
                    maxArea = Math.max(Math.min(height[l], hr) * (r - l), maxArea);
                }
            } else {
                r--;
                if (height[r] > hr) {
                    maxArea = Math.max(Math.min(height[r], hl) * (r - l), maxArea);
                }
            }
        }
        return maxArea;
    }

    // 16. 最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int third = target / 3, first = -1;
        while (++first < len && nums[first] <= third) ;
        first = Math.min(first, len - 2);
        if (first == 0)
            return nums[0] + nums[1] + nums[2];
        int res = nums[first - 1] + nums[first] + nums[first + 1];
        int minDif = Math.abs(res - target);
        for (int l = 0; l < first; l++) {
            int m = l + 1, r = len - 1;
            int left = nums[l];
            while (m < r) {
                int sum = left + nums[m] + nums[r], dif = Math.abs(sum - target);
                if (dif < minDif) {
                    minDif = dif;
                    res = sum;
                }
                if (sum < target) m++;
                else if (sum > target) r--;
                else return target;
            }
        }
        return res;
    }

    // 31. 下一个排列
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return;
        int index = len;
        while (--index > 0 && nums[index - 1] >= nums[index]) ;
        if (index > 0)
            for (int i = len - 1; i >= index; i--)
                if (nums[i] > nums[index - 1]) {
                    int temp = nums[index - 1];
                    nums[index - 1] = nums[i];
                    nums[i] = temp;
                    break;
                }
        for (int i = index, j = len - 1; i < j; i++, j--) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
        }
    }

    // 34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);

    }

    private int[] searchRange(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            int value = nums[mid];
            if (value < target)
                left = mid + 1;
            else if (value > target)
                right = mid - 1;
            else {
                left = searchRange(nums, left, mid - 1, target)[0];
                right = searchRange(nums, mid + 1, right, target)[1];
                if (left == -1) left = mid;
                if (right == -1) right = mid;
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

    // 39. 组合总和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, candidates.length, target);
    }

    // len >= 1
    private List<List<Integer>> combinationSum(int[] candidates, int len, int target) {
        List<List<Integer>> listList = new LinkedList<>();
        int last = candidates[len - 1];

        if (target % last == 0) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < target / last; i++) list.add(last);
            listList.add(list);
        }
        if (len == 1) return listList;
        for (int count = 0; target > 0; target -= last, count++) {
            List<List<Integer>> subListList = combinationSum(candidates, len - 1, target);
            List<Integer> listAdded = new LinkedList<>();
            for (int i = 0; i < count; i++) listAdded.add(last);
            for (List<Integer> list : subListList) list.addAll(listAdded);
            listList.addAll(subListList);
        }
        return listList;
    }

    // 55. 跳跃游戏
    public boolean canJump(int[] nums) {
        return canJump(nums, nums.length - 1);
    }

    private boolean canJump(int[] nums, int end) {
        if (end == 0) return true;
        for (int i = end - 1; i >= 0; i--) if (i + nums[i] >= end) return canJump(nums, i);
        return false;
    }

    // 56. 合并区间
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> list = new LinkedList<>();
        for (int i = 0; i < intervals.size(); ) {
            Interval pre = intervals.get(i);
            int j = i;
            while (++j < intervals.size()) {
                Interval cur = intervals.get(j);
                if (pre.end >= cur.start) pre.end = Math.max(pre.end, cur.end);
                else break;
            }
            list.add(pre);
            i = j;
        }
        return list;
    }

    // 376. 摆动序列
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1]) up = down + 1;
            else if (nums[i] < nums[i - 1]) down = up + 1;
        return Math.max(up, down);
    }

    // 474. 一和零
    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxForm(strs, strs.length - 1, m, n);
    }

    private int findMaxForm(String[] strs, int end, int m, int n) {
        if (end < 0) return 0;
        String last = strs[end];
        int count0 = 0;
        for (char c : last.toCharArray())
            if (c == '0')
                count0++;
        int count1 = last.length() - count0;
        int noLast = findMaxForm(strs, end - 1, m, n);
        if (m < count0 || n < count1)
            return noLast;
        return Math.max(findMaxForm(strs, end - 1, m - count0, n - count1) + 1, noLast);
    }

    public static void main(String[] args) {
        new ArraySolution().wiggleSort(new int[]{
                4, 5, 5, 6
        });
    }

    // 179. 最大数
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strings[i] = String.valueOf(nums[i]);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (strings.length > 0 && strings[0].equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        for (String string : strings) builder.append(string);
        return builder.toString();
    }

    // 274. H指数
    public int hIndex(int[] citations) {
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int citation : citations) {
            Integer count = map.get(citation);
            if (count == null) count = 0;
            map.put(citation, count + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int citation = entry.getKey();
            sum += entry.getValue();
            if (sum >= citation) return citation;
        }
        return citations.length;
    }

    // wsg 324. 摆动排序 II
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1]) {
                int next = i;
                while (++next < nums.length && nums[i] == nums[next]) ;
                int temp = nums[i] > nums[next] ^ i % 2 == 0 ? i - 1 : i;
                nums[temp] += nums[next];
                nums[next] = nums[temp] - nums[next];
                nums[temp] -= nums[next];
            } else if ((i % 2 == 1 && nums[i - 1] > nums[i]) || (i % 2 == 0 && nums[i - 1] < nums[i])) {
                nums[i] += nums[i - 1];
                nums[i - 1] = nums[i] - nums[i - 1];
                nums[i] -= nums[i - 1];
            }
    }
}
