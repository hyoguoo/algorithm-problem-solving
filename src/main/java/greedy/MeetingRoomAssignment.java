/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1931
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomAssignment {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Meeting> meetingList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int[] meeting = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetingList.add(new Meeting(meeting[0], meeting[1]));
        }

        System.out.print(getCountList(meetingList));
    }

    private static int getCountList(List<Meeting> meetingList) {
        meetingList.sort((o1, o2) -> {
            if (o1.endTime != o2.endTime) return o1.endTime - o2.endTime;
            return o1.startTime - o2.startTime;
        });

        int count = 0;
        int endTime = 0;

        for (Meeting meeting : meetingList) {
            if (endTime <= meeting.startTime) {
                endTime = meeting.endTime;
                count++;
            }
        }

        return count;
    }

    static class Meeting {
        public final int startTime;
        public final int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
