/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30979
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PadaengiCare {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] fValues = Arrays.stream(bufferedReader.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(t, n, fValues).getMessage());
    }

    private static PadaengStatus solution(int t, int n, int[] fValues) {
        long totalCandyTime = Arrays.stream(fValues).sum();

        return totalCandyTime >= t
                ? PadaengStatus.HAPPY
                : PadaengStatus.CRY;
    }

    enum PadaengStatus {
        HAPPY("Padaeng_i Happy"),
        CRY("Padaeng_i Cry");

        private final String message;

        PadaengStatus(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
