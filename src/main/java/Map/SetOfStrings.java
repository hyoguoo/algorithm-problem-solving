/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1037
 */

package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetOfStrings {

    static Map<String, Integer> mapOfStrings = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < numbers[0]; i++) mapOfStrings.put(bufferedReader.readLine(), 0);
        for (int i = 0; i < numbers[1]; i++) {
            if (mapOfStrings.containsKey(bufferedReader.readLine())) count++;
        }
        System.out.println(count);
    }
}
