/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1333
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissedCall {

    private static final int CALL_DURATION = 1;
    private static final int SONG_INTERVAL = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int songCount = info[0];
        int songDuration = info[1];
        int callInterval = info[2];

        System.out.print(solution(songCount, songDuration, callInterval));
    }

    private static int solution(int songCount, int songDuration, int callInterval) {
        int albumEnd = songCount * songDuration + (songCount - 1) * SONG_INTERVAL;

        for (int t = 0; ; t += callInterval) {
            if (t >= albumEnd) {
                return t;
            }

            boolean overlapsSong = false;

            for (int i = 0; i < songCount; i++) {
                int start = i * (songDuration + SONG_INTERVAL);
                int end = start + songDuration;
                if (t < end && t + CALL_DURATION > start) {
                    overlapsSong = true;
                    break;
                }
            }

            if (!overlapsSong) {
                return t;
            }
        }
    }
}
