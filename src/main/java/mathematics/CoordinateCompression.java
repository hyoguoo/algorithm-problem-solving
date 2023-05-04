/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18870
 * Cheat Level: 2
 * Algorithm: Mathematics / DataStructure.Map
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoordinateCompression {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        Map<Integer, Integer> lowNumberCountMap = getLowNumberCountMap(sortedNumbers);

        printResult(numbers, lowNumberCountMap);
    }

    private static Map<Integer, Integer> getLowNumberCountMap(int[] sortedNumbers) {
        Map<Integer, Integer> lowNumberCountMap = new HashMap<>();
        int count = 0;
        for (int sortedNumber : sortedNumbers) {
            if (!lowNumberCountMap.containsKey(sortedNumber)) lowNumberCountMap.put(sortedNumber, count++);
        }
        return lowNumberCountMap;
    }

    private static void printResult(int[] numbers, Map<Integer, Integer> lowNumberCountMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers) stringBuilder.append(lowNumberCountMap.get(number)).append(" ");
        System.out.println(stringBuilder);
    }
}
