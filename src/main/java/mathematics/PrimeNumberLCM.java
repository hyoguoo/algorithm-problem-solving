/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21919
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeNumberLCM {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(numbers).max().getAsInt();

        boolean[] isPrime = getIsPrime(max);
        long answer = getMultiply(numbers, isPrime);

        System.out.println(answer == 1 ? -1 : answer);
    }

    private static long getMultiply(int[] numbers, boolean[] isPrime) {
        long answer = 1;

        for (int number : numbers) {
            if (isPrime[number]) continue;
            answer *= number;
            isPrime[number] = true;
        }
        return answer;
    }

    private static boolean[] getIsPrime(int max) {
        boolean[] isPrime = new boolean[max + 1];
        isPrime[1] = true;

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) continue;
            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }

        return isPrime;
    }
}