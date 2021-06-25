package wsg.oj.java.leetcode.problems;


import com.eclipsesource.json.JsonArray;

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
