/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11653
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(bufferedReader.readLine());

        printResult(solution());
    }

    private static List<Integer> solution() {
        List<Integer> resultList = new ArrayList<>();

        if (number == 1) return resultList;
        while (true) {
            if (!divide(resultList)) {
                resultList.add(number);
                return resultList;
            }
        }
    }

    private static boolean divide(List<Integer> resultList) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                resultList.add(i);
                number /= i;
                return true;
            }
        }

        return false;
    }

    private static void printResult(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer num : result) stringBuilder.append(num).append("\n");

        System.out.println(stringBuilder);
    }
}
