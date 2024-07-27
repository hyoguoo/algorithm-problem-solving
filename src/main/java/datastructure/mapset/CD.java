/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4158
 * Cheat Level: 0
 * Algorithm: Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CD {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int numberOfA = info[0];
            int numberOfB = info[1];
            if (numberOfA == 0 && numberOfB == 0) {
                break;
            }
            int[] numbersA = new int[numberOfA];
            int[] numbersB = new int[numberOfB];

            for (int i = 0; i < numberOfA; i++) {
                numbersA[i] = Integer.parseInt(bufferedReader.readLine());
            }

            for (int i = 0; i < numberOfB; i++) {
                numbersB[i] = Integer.parseInt(bufferedReader.readLine());
            }

            stringBuilder.append(solution(numbersA, numbersB)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] numbersA, int[] numbersB) {
        Set<Integer> exists = new HashSet<>();
        int existsCount = 0;
        for (int number : numbersA) {
            exists.add(number);
        }
        for (int number : numbersB) {
            if (exists.contains(number)) {
                existsCount++;
            }
        }

        return existsCount;
    }
}
