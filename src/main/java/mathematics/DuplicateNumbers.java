/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15719
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.IOException;

public class DuplicateNumbers {

    private static final byte[] buffer = new byte[78888905];
    private static int next;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer, 0, buffer.length);

        long n = nextInt();
        long sum = calculateSum(n);

        System.out.print(sum - (n * (n - 1) / 2));
    }

    private static long calculateSum(long n) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nextInt();
        }

        return sum;
    }


    private static int nextInt() {
        int n = buffer[next++] - '0';
        int b;

        while ((b = buffer[next++]) >= '0') {
            n = (n * 10) + (b - '0');
        }

        return n;
    }
}
