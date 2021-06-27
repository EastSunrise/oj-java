package wsg.oj.java.leetcode.problems;


import com.eclipsesource.json.JsonArray;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility of testing.
 *
 * @author Kingen
 * @since 2021/6/19
 */
public class TestUtil {

    public static int[] stringToIntArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntArray(cols.toString());
        }
        return arr;
    }

    public static List<Integer> stringToIntList(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new ArrayList<>(0);
        }

        String[] parts = input.split(",");
        List<Integer> output = new ArrayList<>(parts.length);
        for (String s : parts) {
            output.add(Integer.parseInt(s.trim()));
        }
        return output;
    }

    public static List<List<Integer>> stringToInt2dList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> res = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            res.add(stringToIntList(cols.toString()));
        }
        return res;
    }

    public static char[] stringToCharArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new char[0];
        }

        String[] parts = input.split(",");
        char[] output = new char[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = part.charAt(1);
        }
        return output;
    }

    public static char[][] stringToChar2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new char[0][0];
        }

        char[][] arr = new char[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToCharArray(cols.toString());
        }
        return arr;
    }

}
