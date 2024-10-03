/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2108
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        double[] numbers = new double[length];
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            double number = Double.parseDouble(bufferedReader.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
            numbers[i] = number;
        }

        System.out.print(solution(numbers, map));
    }

    private static String solution(double[] numbers, Map<Double, Integer> map) {
        Arrays.sort(numbers);
        double average = Math.round(getSum(numbers) / numbers.length);
        double median = numbers[numbers.length / 2];
        double mode = getMode(map);
        double range = numbers[numbers.length - 1] - numbers[0];

        return String.format("%.0f%n%.0f%n%.0f%n%.0f%n", average, median, mode, range);

    }

    private static int getMode(Map<Double, Integer> map) {
        List<Map.Entry<Double, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        Integer maxValue = entryList.get(0).getValue();
        entryList.removeIf(entry -> !entry.getValue().equals(maxValue));
        entryList.sort((o1, o2) -> (int) (o1.getKey() - o2.getKey()));

        return (int) Math.round(entryList.size() > 1
                ? entryList.get(1).getKey()
                : entryList.get(0).getKey());
    }

    private static double getSum(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
