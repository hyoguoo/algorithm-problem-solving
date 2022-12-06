/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10816
 */

package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberCard2 {

    static final Map<Integer, Integer> mapOfNumbers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] cards = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        mappingCards(cards);
        int[] countList = countNumbers(numbers);

        printResult(countList);
    }

    private static void printResult(int[] countList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int count : countList) stringBuffer.append(count).append(" ");
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        System.out.println(stringBuffer);
    }

    private static int[] countNumbers(int[] numbers) {
        int[] countList = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) countList[i] = mapOfNumbers.getOrDefault(numbers[i], 0);

        return countList;
    }

    private static void mappingCards(int[] cards) {
        for (int card : cards) {
            if (mapOfNumbers.containsKey(card)) mapOfNumbers.put(card, mapOfNumbers.get(card) + 1);
            else mapOfNumbers.put(card, 1);
        }
    }
}
