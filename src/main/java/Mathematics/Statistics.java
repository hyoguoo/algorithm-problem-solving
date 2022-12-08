/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2108
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Statistics {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        float[] numbers = new float[length];
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            double number = Double.parseDouble(bufferedReader.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
            numbers[i] = (float) number;
        }
        Arrays.sort(numbers);
        printResult(length, numbers, map);
    }

    private static void printResult(int length, float[] numbers, Map<Double, Integer> map) {
        double sum = getSum(numbers);
        System.out.println(Math.round(sum / length));
        System.out.println((int) numbers[length / 2]);
        System.out.println(getMode(map));
        System.out.println((int) (numbers[length - 1] - numbers[0]));
    }

    private static int getMode(Map<Double, Integer> map) {
        List<Map.Entry<Double, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        Integer maxValue = entryList.get(0).getValue();
        entryList.removeIf(entry -> !entry.getValue().equals(maxValue));
        entryList.sort((o1, o2) -> (int) (o1.getKey() - o2.getKey()));

        return (int) Math.round(entryList.size() > 1 ? entryList.get(1).getKey() : entryList.get(0).getKey());
    }

    private static double getSum(float[] numbers) {
        double sum = 0;
        for (float number : numbers) sum += number;

        return sum;
    }
}
