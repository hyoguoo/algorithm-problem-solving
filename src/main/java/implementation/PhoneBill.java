/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3226
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;

public class PhoneBill {

    private static final int MINUTE_PER_HOUR = 60;
    private static final LocalTime PEAK_START_TIME = LocalTime.of(7, 0);
    private static final LocalTime PEAK_END_TIME = LocalTime.of(19, 0);
    private static final int PEAK_FEE = 10;
    private static final int NORMAL_FEE = 5;
    private static final int PEAK_START = PEAK_START_TIME.getHour() * MINUTE_PER_HOUR + PEAK_START_TIME.getMinute();
    private static final int PEAK_END = PEAK_END_TIME.getHour() * MINUTE_PER_HOUR + PEAK_END_TIME.getMinute();


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int callCount = Integer.parseInt(bufferedReader.readLine());
        Call[] calls = new Call[callCount];

        for (int i = 0; i < callCount; i++) {
            String[] callInfo = bufferedReader.readLine().split(" ");
            int[] timeInfo = Arrays.stream(callInfo[0].split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int duration = Integer.parseInt(callInfo[1]);
            calls[i] = new Call(LocalTime.of(timeInfo[0], timeInfo[1]), duration);
        }

        System.out.print(solution(calls));
    }

    private static int solution(Call[] calls) {
        return Arrays.stream(calls)
                .mapToInt(PhoneBill::calculateFee)
                .sum();
    }

    private static int calculateFee(Call call) {
        int start = call.time.getHour() * MINUTE_PER_HOUR + call.time.getMinute();
        int duration = call.duration;
        int end = start + duration;

        int overlap = Math.max(0, Math.min(end, PEAK_END) - Math.max(start, PEAK_START));

        return duration * NORMAL_FEE + overlap * (PEAK_FEE - NORMAL_FEE);
    }

    static class Call {

        private final LocalTime time;
        private final int duration;

        public Call(LocalTime time, int duration) {
            this.time = time;
            this.duration = duration;
        }
    }
}
