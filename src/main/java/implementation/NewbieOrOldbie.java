/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19944
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewbieOrOldbie {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static Classification solution(int n, int m) {
        if (m <= 2) {
            return Classification.NEWBIE;
        } else if (m <= n) {
            return Classification.OLDBIE;
        } else {
            return Classification.TLE;
        }
    }

    enum Classification {
        NEWBIE("NEWBIE!"),
        OLDBIE("OLDBIE!"),
        TLE("TLE!");

        private final String message;

        Classification(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
