/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1929
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindPrime {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[] primes = solution(numbers[1]);

        for (int i = numbers[0]; i < primes.length; i++) {
            if (primes[i]) System.out.println(i);
        }
    }

    private static boolean[] solution(int target) {
        boolean[] primes = new boolean[target + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= target; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= target; j += i) primes[j] = false;
            }
        }
        return primes;
    }
}
