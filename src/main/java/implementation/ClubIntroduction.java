/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28691
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClubIntroduction {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ClubInput clubInput = new ClubInput(bufferedReader.readLine());

        System.out.print(solution(clubInput));
    }

    private static Club solution(ClubInput clubInput) {
        return Club.of(clubInput.getInitial());
    }

    enum Club {
        MATKOR("M", "MatKor"),
        WICYS("W", "WiCys"),
        CYKOR("C", "CyKor"),
        ALKOR("A", "AlKor"),
        CLEAR("$", "$clear");

        private final String initial;
        private final String name;

        Club(String initial, String name) {
            this.initial = initial;
            this.name = name;
        }

        public static Club of(String initial) {
            return Arrays.stream(values())
                    .filter(club -> club.initial.equals(initial))
                    .findFirst()
                    .orElseThrow();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class ClubInput {

        private final String initial;

        public ClubInput(String initial) {
            this.initial = initial;
        }

        public String getInitial() {
            return initial;
        }
    }
}
