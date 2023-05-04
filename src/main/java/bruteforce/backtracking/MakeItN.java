/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17255
 * Cheat Level: 0
 * Algorithm: Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeItN {

    final static Map<String, Integer> stringNumberMap = new HashMap<>();
    final static List<String> answerList = new ArrayList<>();
    static String DIST;
    static int LENGTH;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        init();
        backtracking("", new ArrayList<>());
        System.out.println(count);
    }

    private static void backtracking(String src, ArrayList<String> addedOrder) {
        if (src.length() == LENGTH) {
            if (src.equals(DIST)) {
                String answer = listToString(addedOrder);
                if (answerList.contains(answer)) return;
                answerList.add(answer);
                count++;
            }
            return;
        }

        for (String stringNumber : stringNumberMap.keySet()) {
            if (stringNumberMap.get(stringNumber) == 0) continue;
            stringNumberMap.put(stringNumber, stringNumberMap.get(stringNumber) - 1);
            addedOrder.add(src);
            backtracking(src + stringNumber, addedOrder);
            backtracking(stringNumber + src, addedOrder);
            addedOrder.remove(addedOrder.size() - 1);
            stringNumberMap.put(stringNumber, stringNumberMap.get(stringNumber) + 1);
        }
    }

    private static String listToString(ArrayList<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringList) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DIST = bufferedReader.readLine();
        int[] numbers = Arrays.stream(DIST.split("")).mapToInt(Integer::parseInt).toArray();
        LENGTH = numbers.length;
        for (int number : numbers) {
            stringNumberMap.put(String.valueOf(number), stringNumberMap.getOrDefault(String.valueOf(number), 0) + 1);
        }
    }
}
