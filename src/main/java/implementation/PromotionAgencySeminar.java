/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30087
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PromotionAgencySeminar {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int seminarCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (seminarCount-- > 0) {
            stringBuilder.append(solution(bufferedReader.readLine())).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String seminarName) {
        return Seminar.fromName(seminarName).roomNumber;
    }

    enum Seminar {
        ALGORITHM("Algorithm", "204"),
        DATA_ANALYSIS("DataAnalysis", "207"),
        ARTIFICIAL_INTELLIGENCE("ArtificialIntelligence", "302"),
        CYBER_SECURITY("CyberSecurity", "B101"),
        NETWORK("Network", "303"),
        STARTUP("Startup", "501"),
        TEST_STRATEGY("TestStrategy", "105");

        private final String name;
        private final String roomNumber;

        Seminar(String name, String roomNumber) {
            this.name = name;
            this.roomNumber = roomNumber;
        }

        public static Seminar fromName(String name) {
            return Arrays.stream(values())
                    .filter(seminar -> seminar.name.equals(name))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
