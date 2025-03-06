/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3863
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HappyTelephones {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int callCount = info[0];
            int sectionCount = info[1];
            if (callCount == 0 && sectionCount == 0) {
                break;
            }
            CallInfo[] callInfos = new CallInfo[callCount];
            for (int i = 0; i < callCount; i++) {
                int[] callInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                callInfos[i] = new CallInfo(callInfo[2], callInfo[3]);
            }
            SectionInfo[] sectionInfos = new SectionInfo[sectionCount];
            for (int i = 0; i < sectionCount; i++) {
                int[] sectionInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                sectionInfos[i] = new SectionInfo(sectionInfo[0], sectionInfo[1]);
            }

            stringBuilder.append(solution(callInfos, sectionInfos)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(CallInfo[] callInfos, SectionInfo[] sectionInfos) {
        List<Integer> count = new ArrayList<>();

        for (SectionInfo sectionInfo : sectionInfos) {
            int totalCalls = 0;
            for (CallInfo callInfo : callInfos) {
                if (isIntersected(callInfo, sectionInfo)) {
                    totalCalls++;
                }
            }
            count.add(totalCalls);
        }

        return count.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
    }

    private static boolean isIntersected(CallInfo callInfo, SectionInfo sectionInfo) {
        int callStartTime = callInfo.startTime;
        int callEndTime = callInfo.startTime + callInfo.duration;
        int sectionStartTime = sectionInfo.startTime;
        int sectionEndTime = sectionInfo.startTime + sectionInfo.duration;

        return callStartTime < sectionEndTime && callEndTime > sectionStartTime;

    }

    static class CallInfo {

        private final int startTime;
        private final int duration;

        public CallInfo(int startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }
    }

    static class SectionInfo {

        private final int startTime;
        private final int duration;

        public SectionInfo(int startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }
    }
}
