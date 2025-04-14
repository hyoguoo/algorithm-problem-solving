/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2023
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CuriousPrimeNumber {

    private static final int[] SINGLE_DIGIT_PRIME = {2, 3, 5, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        List<String> curiousPrimeList = new ArrayList<>();
        Arrays.stream(SINGLE_DIGIT_PRIME)
                .forEach(i -> findCuriousPrime(String.valueOf(i), curiousPrimeList, n));
        return curiousPrimeList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
    }

    private static void findCuriousPrime(String numberString, List<String> curiousPrimeList, int n) {
        if (numberString.length() == n) {
            curiousPrimeList.add(numberString);
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            String nextNumberString = numberString + i;
            int nextNumber = Integer.parseInt(nextNumberString);
            if (isNotPrime(nextNumber)) {
                continue;
            }
            findCuriousPrime(nextNumberString, curiousPrimeList, n);
        }
    }

    private static boolean isNotPrime(int n) {
        if (n < 2) {
            return true;
        }
        if (n == 2) {
            return false;
        }
        if (n % 2 == 0) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
