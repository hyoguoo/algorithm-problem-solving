/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2581
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int M = Integer.parseInt(bufferedReader.readLine());
        final int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> primeNumbers = findPrimeNumbers(M, N);

        if (primeNumbers.isEmpty()) System.out.println(-1);
        else {
            System.out.println(primeNumbers.stream().mapToInt(Integer::intValue).sum());
            System.out.println(primeNumbers.get(0));
        }
    }

    public static List<Integer> findPrimeNumbers(int m, int n) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) primeNumbers.add(i);
        }

        return primeNumbers;
    }

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
