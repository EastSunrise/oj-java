package cn.wsg.oj.leetcode.problems.base;


import com.eclipsesource.json.JsonArray;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Utility of testing.
 *
 * @author Kingen
 */
public class TestUtil {

    public static int[][] stringToInt2dArray(String input) {
        return stringTo2dArray(input, int[][]::new, int[]::new,
            (arr, i, str) -> arr[i] = Integer.parseInt(str));
    }

    public static int[] stringToIntArray(String input) {
        return stringToArray(input, int[]::new, (arr, i, str) -> arr[i] = Integer.parseInt(str));
    }

    public static char[][] stringToChar2dArray(String input) {
        return stringTo2dArray(input, char[][]::new, char[]::new,
            (arr, i, str) -> arr[i] = str.charAt(1));
    }

    public static char[] stringToCharArray(String input) {
        return stringToArray(input, char[]::new, (arr, i, str) -> arr[i] = str.charAt(1));
    }

    public static double[] stringToDoubleArray(String input) {
        return stringToArray(input, double[]::new,
            (arr, i, str) -> arr[i] = Double.parseDouble(str));
    }

    public static String[][] stringToString2dArray(String input) {
        return stringTo2dArray(input, String[][]::new, String[]::new,
            (arr, i, str) -> arr[i] = str.substring(1, str.length() - 1));
    }

    public static String[] stringToStringArray(String input) {
        return stringToArray(input, String[]::new,
            (arr, i, str) -> arr[i] = str.substring(1, str.length() - 1));
    }

    private static <T> T[] stringTo2dArray(String input, Function<Integer, T[]> constructor,
        Function<Integer, T> eleConstructor, TriConsumer<T, Integer, String> consumer) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return constructor.apply(0);
        }

        T[] arr = constructor.apply(jsonArray.size());
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToArray(cols.toString(), eleConstructor, consumer);
        }
        return arr;
    }

    private static <T, E> T stringToArray(String input, Function<Integer, T> constructor,
        TriConsumer<T, Integer, String> consumer) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return constructor.apply(0);
        }

        String[] parts = input.split(",");
        T res = constructor.apply(parts.length);
        for (int i = 0; i < parts.length; i++) {
            consumer.accept(res, i, parts[i].trim());
        }
        return res;
    }


    public static List<List<Integer>> stringToInt2dList(String input) {
        return stringTo2dList(input, Integer::parseInt);
    }

    public static List<Integer> stringToIntList(String input) {
        return stringToList(input, Integer::parseInt);
    }

    public static List<List<String>> stringToString2dList(String input) {
        return stringTo2dList(input, str -> str.substring(1, str.length() - 1));
    }

    public static List<String> stringToStringList(String input) {
        return stringToList(input, str -> str.substring(1, str.length() - 1));
    }

    private static <T> List<List<T>> stringTo2dList(String input, Function<String, T> converter) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<>(0);
        }

        List<List<T>> res = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            res.add(stringToList(cols.toString(), converter));
        }
        return res;
    }

    private static <T> List<T> stringToList(String input, Function<String, T> converter) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new ArrayList<>(0);
        }

        String[] parts = input.split(",");
        List<T> res = new ArrayList<>(parts.length);
        for (String part : parts) {
            res.add(converter.apply(part.trim()));
        }
        return res;
    }

    private interface TriConsumer<T, U, V> {

        void accept(T t, U u, V v);
    }
}
