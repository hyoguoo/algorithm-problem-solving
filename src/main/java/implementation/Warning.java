/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3029
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Warning {

    private static final String FORMAT = "HH:mm:ss";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        LocalTime localTimeA = LocalTime.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern(FORMAT));
        LocalTime localTimeB = LocalTime.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern(FORMAT));

        if (localTimeA.equals(localTimeB)) {
            System.out.print("24:00:00");
            return;
        }
        System.out.print(solution(localTimeA, localTimeB).format(DateTimeFormatter.ofPattern(FORMAT)));
    }

    private static LocalTime solution(LocalTime localTimeA, LocalTime localTimeB) {
        return localTimeB.isAfter(localTimeA) ?
                LocalTime.ofSecondOfDay((long) localTimeB.toSecondOfDay() - localTimeA.toSecondOfDay()) :
                LocalTime.ofSecondOfDay((long) 24 * 3600 - (localTimeA.toSecondOfDay() - localTimeB.toSecondOfDay()));
    }
}

/*
00:00:00
00:00:00
 */
