/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2810
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CupHolder {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        Seat[] seats = Arrays.stream(bufferedReader.readLine().split(""))
                .map(Seat::of)
                .toArray(Seat[]::new);

        System.out.print(solution(seats));
    }

    private static int solution(Seat[] seats) {
        int count = 1;

        for (int i = 0; i < seats.length; i++) {
            Seat seat = seats[i];
            if (seat == Seat.L) {
                i++;
            }
            count++;
        }

        return Math.min(count, seats.length);
    }

    enum Seat {
        S("S"),
        L("L");

        private final String value;

        Seat(String value) {
            this.value = value;
        }

        public static Seat of(String value) {
            return Arrays.stream(Seat.values())
                    .filter(seat -> seat.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
