/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9080
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PCRoomCharges {

    private static final int NIGHT_CHARGE_PER_HOUR = 5000;
    private static final int BASIC_CHARGE_PER_HOUR = 1000;
    private static final int MINUTE_PER_HOUR = 60;
    private static final int HOUR_PER_DAY = 24;
    private static final int MINUTE_PER_DAY = HOUR_PER_DAY * MINUTE_PER_HOUR;
    private static final int NIGHT_END_HOUR = 8;
    private static final int OFFSET_HOUR = 2;
    private static final int NIGHT_END_MINUTE = (NIGHT_END_HOUR + OFFSET_HOUR) * MINUTE_PER_HOUR;
    private static final int NIGHT_BENEFIT_REMAIN;
    private static final int NIGHT_BENEFIT_LIMIT;

    static {
        NIGHT_BENEFIT_REMAIN = NIGHT_CHARGE_PER_HOUR / BASIC_CHARGE_PER_HOUR * MINUTE_PER_HOUR;
        NIGHT_BENEFIT_LIMIT = NIGHT_END_MINUTE - NIGHT_BENEFIT_REMAIN;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            String[] info = bufferedReader.readLine().split(" ");
            int[] timeInfo = Arrays.stream(info[0].split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int startMinute = timeInfo[0] * MINUTE_PER_HOUR + timeInfo[1];
            int usageTime = Integer.parseInt(info[1]);

            stringBuilder.append(
                            solution(
                                    (startMinute + OFFSET_HOUR * MINUTE_PER_HOUR) % MINUTE_PER_DAY,
                                    usageTime
                            )
                    )
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int currentMinute, int remainTime) {
        int totalCharge = 0;

        while (remainTime > 0) {
            if (isNightTimeBeneficial(currentMinute, remainTime)) {
                totalCharge += NIGHT_CHARGE_PER_HOUR;
                remainTime = remainTime - (NIGHT_END_MINUTE - currentMinute);
                currentMinute = NIGHT_END_MINUTE;
            } else {
                totalCharge += BASIC_CHARGE_PER_HOUR;
                currentMinute += MINUTE_PER_HOUR;
                currentMinute %= MINUTE_PER_DAY;
                remainTime -= MINUTE_PER_HOUR;
            }
        }

        return totalCharge;
    }

    private static boolean isNightTimeBeneficial(int currentMinute, int remainTime) {
        return currentMinute <= NIGHT_BENEFIT_LIMIT && remainTime >= NIGHT_BENEFIT_REMAIN;
    }
}
