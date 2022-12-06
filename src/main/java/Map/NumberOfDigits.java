/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2577
 */

package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberOfDigits {

    public static final int LENGTH = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long multiply = 1;

        for (int i = 0; i < LENGTH; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            multiply *= input;
        }

        Map<Integer, Integer> numberOfDigits = getNumberOfDigits(multiply);

        for (int i = 0; i <= 9; i++) {
            System.out.println(numberOfDigits.getOrDefault(i, 0));
        }
    }

    private static Map<Integer, Integer> getNumberOfDigits(long multiply) {
        String[] str = String.valueOf(multiply).split("");

        Map<Integer, Integer> map = new HashMap<>();
        for (String s : str) {
            int number = Integer.parseInt(s);
            if (map.containsKey(number)) map.put(number, map.get(number) + 1);
            else map.put(number, 1);

        }
        return map;
    }
}
