package wsg.oj.java.leetcode.problems.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Kingen
 */
public class StringSolution {

    // 10. 正则表达式匹配
    public boolean isMatch(String s, String p) {
        if ("".equals(p)) {
            return "".equals(s);
        }
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        return isMatch(ss, ps, ss.length, ps.length);
    }

    private boolean isMatch(char[] ss, char[] ps, int sl, int pl) {
        if (pl == 0) {
            return sl == 0;
        }
        char pLast = ps[pl - 1];
        if (pl == 1) {
            return pLast != '*' && (pl == sl && (pLast == '.' || (ss[sl - 1] == pLast)));
        }
        switch (pLast) {
            case '.':
                return sl > 0 && isMatch(ss, ps, sl - 1, pl - 1);
            case '*':
                pLast = ps[pl - 2];
                switch (pLast) {
                    case '*':
                        return isMatch(ss, ps, sl, sl - 1);
                    case '.':
                        for (int i = 0; i < sl; i++) {
                            if (isMatch(ss, ps, sl - i, pl - 2)) {
                                return true;
                            }
                        }
                        return isMatch(ss, ps, 0, pl - 2);
                    default:
                        for (int i = 0; i < sl; i++) {
                            if (isMatch(ss, ps, sl - i, pl - 2)) {
                                return true;
                            }
                            if (ss[sl - i - 1] != pLast) {
                                return false;
                            }
                        }
                        return isMatch(ss, ps, 0, pl - 2);
                }
            default:
                return sl > 0 && ss[sl - 1] == pLast && isMatch(ss, ps, sl - 1, pl - 1);
        }
    }

    // 65. 有效数字
    public boolean isNumber(String s) {
        s = s.replaceAll(" ", "");
        for (char c : s.toCharArray()) {
            if (c != 'e' && c != '.' && (c < '0' || c > '9')) {
                return false;
            }
        }
        String[] parts = s.split("e", 3);
        if (parts.length > 2 || parts.length == 0) {
            return false;
        }
        for (String part : parts) {
            if ("".equals(part) || part.startsWith(".") || part.endsWith(".") || part
                .matches(".*\\..*\\..*")) {
                return false;
            }
        }
        return true;
    }

    // 187. 重复的DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len < 10) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= len - 10; i++) {
            String str = s.substring(i, i + 10);
            Integer count = map.get(str);
            if (count == null) {
                count = 0;
            }
            map.put(str, count + 1);
        }
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    // 388. 文件的最长绝对路径
    public int lengthLongestPath(String input) {
        char[] chars = (input + "\n").toCharArray();
        int level = 0, len = 0, length = 0, max = 0;
        boolean isFile = false;
        Stack<Integer> stack = new Stack<>();
        for (char c : chars) {
            if (c == '\n') {
                if (!isFile) {
                    len++;
                }
                while (stack.size() > level) {
                    length -= stack.pop();
                }
                stack.push(len);
                length += len;
                if (isFile) {
                    max = Math.max(length, max);
                }
                level = len = 0;
                isFile = false;
            } else if (c == '\t') {
                level++;
            } else {
                if (c == '.') {
                    isFile = true;
                }
                len++;
            }
        }
        return max;
    }

    // 399. 除法求值
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, GroupValue> map = new HashMap<>();
        List<Set<String>> list = new LinkedList<>();
        int groupId = 0;
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            double value = values[i];
            String a = equation[0], b = equation[1];
            GroupValue groupValueA = map.get(a);
            GroupValue groupValueB = map.get(b);
            if (groupValueA != null) {
                if (groupValueB != null) {
                    int idA = groupValueA.groupId, idB = groupValueB.groupId;
                    if (idA != idB) {
                        Set<String> setA = list.get(groupValueA.groupId);
                        double k = value * groupValueB.value / groupValueA.value;
                        for (String s : setA) {
                            GroupValue groupValueS = map.get(s);
                            groupValueS.groupId = idB;
                            groupValueS.value *= k;
                        }
                        list.get(idB).addAll(setA);
                        list.set(idA, null);
                    }
                } else {
                    map.put(b, new GroupValue(groupValueA.groupId, groupValueA.value / value));
                }
            } else {
                if (groupValueB != null) {
                    map.put(a, new GroupValue(groupValueB.groupId, groupValueB.value * value));
                } else {
                    map.put(b, new GroupValue(groupId, 1));
                    map.put(a, new GroupValue(groupId++, value));
                    Set<String> set = new HashSet<>(Arrays.asList(a, b));
                    list.add(set);
                }
            }
        }
        double[] ret = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            GroupValue groupValueX = map.get(query[0]), groupValueY = map.get(query[1]);
            if (groupValueX == null || groupValueY == null
                || groupValueX.groupId != groupValueY.groupId) {
                ret[i] = -1.0;
            } else {
                ret[i] = groupValueX.value / groupValueY.value;
            }
        }
        return ret;
    }

    // 443. 压缩字符串
    public int compress(char[] chars) {
        int charIndex = 0, count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[++charIndex] = c;
                    }
                }
                count = 1;
                chars[++charIndex] = chars[i];
            }
        }
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[++charIndex] = c;
            }
        }
        return charIndex + 1;
    }

    // 537. 复数乘法
    public String complexNumberMultiply(String a, String b) {
        int[] aInts = getInts(a), bInts = getInts(b);
        return "" + (aInts[0] * bInts[0] - aInts[1] * bInts[1])
            + "+" + (aInts[0] * bInts[1] + aInts[1] * bInts[0]) + "i";
    }

    private int[] getInts(String s) {
        String[] ss = s.substring(0, s.length() - 1).split("\\+");
        return new int[]{
            Integer.parseInt(ss[0]), Integer.parseInt(ss[1])
        };
    }

    // 816. 模糊坐标
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> list = new LinkedList<>();
        for (int comma = 1; comma < S.length(); comma++) {
            for (String s1 : getValidString(S.substring(0, comma))) {
                for (String s2 : getValidString(S.substring(comma))) {
                    list.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return list;
    }

    private List<String> getValidString(String s) {
        List<String> list = new LinkedList<>();
        if (s.endsWith("0")) {
            if ("0".equals(s) || !s.startsWith("0")) {
                list.add(s);
            }
        } else if (s.startsWith("0")) {
            list.add("0." + s.substring(1));
        } else {
            list.add(s);
            for (int i = 1; i < s.length(); i++) {
                list.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return list;
    }

    static class GroupValue {

        int groupId;
        double value;

        GroupValue(int groupId, double value) {
            this.groupId = groupId;
            this.value = value;
        }
    }
}