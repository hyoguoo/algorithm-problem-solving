/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4948
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BertrandPostulate {

    final static int MAX = 123456 * 2;
    final static int SQRT_MAX = (int) Math.sqrt(MAX);
    final static boolean[] isNotPrime = new boolean[MAX + 1];

    static {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= SQRT_MAX; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j <= MAX; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == 0) break;
            stringBuilder.append(getPrimeCount(number)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int getPrimeCount(int startNumber) {
        return (int) IntStream.rangeClosed(startNumber + 1, startNumber * 2).filter(i -> !isNotPrime[i]).count();
    }
}
