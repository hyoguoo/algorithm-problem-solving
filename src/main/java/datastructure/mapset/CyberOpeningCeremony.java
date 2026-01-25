/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19583
 * Cheat Level: 0
 * Algorithm: Data Structure / Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CyberOpeningCeremony {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CeremonyTimeInfo ceremonyTimeInfo = parseCeremonyTimeInfo(bufferedReader);

        System.out.print(solution(ceremonyTimeInfo, bufferedReader));
    }

    private static CeremonyTimeInfo parseCeremonyTimeInfo(BufferedReader bufferedReader) throws IOException {
        String[] timeInfo = bufferedReader.readLine().split(" ");
        int[] beginTimeInfo = Arrays.stream(timeInfo[0].split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] endTimeInfo = Arrays.stream(timeInfo[1].split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] streamingEndTimeInfo = Arrays.stream(timeInfo[2].split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalTime beginTime = LocalTime.of(
                beginTimeInfo[0],
                beginTimeInfo[1]
        );
        LocalTime endTime = LocalTime.of(
                endTimeInfo[0],
                endTimeInfo[1]
        );
        LocalTime streamingEndTime = LocalTime.of(
                streamingEndTimeInfo[0],
                streamingEndTimeInfo[1]
        );

        return new CeremonyTimeInfo(
                beginTime,
                endTime,
                streamingEndTime
        );
    }

    private static int solution(CeremonyTimeInfo ceremonyTimeInfo, BufferedReader bufferedReader) throws IOException {
        AttendanceSheet attendanceSheet = new AttendanceSheet(ceremonyTimeInfo);

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            ChatLog chatLog = parseChatLog(input);

            attendanceSheet.logAttendance(chatLog);
        }

        return attendanceSheet.countCompleteAttendances();
    }

    private static ChatLog parseChatLog(String input) {
        String[] logInfo = input.split(" ");
        int[] logTimeInfo = Arrays.stream(logInfo[0].split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalTime logTime = LocalTime.of(
                logTimeInfo[0],
                logTimeInfo[1]
        );
        String nickname = logInfo[1];

        return new ChatLog(logTime, nickname);
    }

    static class AttendanceSheet {

        private final Set<String> attendanceSet;
        private final Set<String> leaveSet;
        private final CeremonyTimeInfo ceremonyTimeInfo;

        public AttendanceSheet(CeremonyTimeInfo ceremonyTimeInfo) {
            this.attendanceSet = new HashSet<>();
            this.leaveSet = new HashSet<>();
            this.ceremonyTimeInfo = ceremonyTimeInfo;
        }

        public void logAttendance(ChatLog chatLog) {
            if (ceremonyTimeInfo.isAttendanceLog(chatLog.getTime())) {
                attendanceSet.add(chatLog.getNickname());
            } else if (ceremonyTimeInfo.isLeaveLog(chatLog.getTime())) {
                leaveSet.add(chatLog.getNickname());
            }
        }

        public int countCompleteAttendances() {
            Set<String> completeAttendanceSet = new HashSet<>(attendanceSet);
            completeAttendanceSet.retainAll(leaveSet);
            return completeAttendanceSet.size();
        }
    }

    static class CeremonyTimeInfo {

        private final LocalTime beginTime;
        private final LocalTime endTime;
        private final LocalTime streamingEndTime;

        public CeremonyTimeInfo(LocalTime beginTime, LocalTime endTime, LocalTime streamingEndTime) {
            this.beginTime = beginTime;
            this.endTime = endTime;
            this.streamingEndTime = streamingEndTime;
        }

        public boolean isAttendanceLog(LocalTime time) {
            return !time.isAfter(beginTime);
        }

        public boolean isLeaveLog(LocalTime time) {
            return !time.isBefore(endTime) && !time.isAfter(streamingEndTime);
        }
    }

    static class ChatLog {

        private final LocalTime time;
        private final String nickname;

        public ChatLog(LocalTime time, String nickname) {
            this.time = time;
            this.nickname = nickname;
        }

        public LocalTime getTime() {
            return time;
        }

        public String getNickname() {
            return nickname;
        }
    }
}
