/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1075
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divide {

    private static final int LIMIT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int f = Integer.parseInt(bufferedReader.readLine());

        System.out.printf("%02d", solution(n, f));
    }

    private static int solution(int n, int f) {
        for (int i = 0; i <= LIMIT; i++) {
            int newN = n / 100 * 100 + i;
            if (newN % f == 0) {
                return newN % 100;
            }
        }

        return 0;
    }
}
