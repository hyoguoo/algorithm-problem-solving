/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20499
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DariusKDA {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split("/"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = info[0];
        int d = info[1];
        int a = info[2];

        System.out.println(solution(k, d, a));
    }

    public static PlayerStatus solution(int k, int d, int a) {
        if (d == 0 || k + a < d) {
            return PlayerStatus.HASU;
        } else {
            return PlayerStatus.GOSU;
        }
    }

    enum PlayerStatus {
        GOSU("gosu"),
        HASU("hasu");

        private final String string;

        PlayerStatus(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}
