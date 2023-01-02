/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1931
 * Cheat Level: 2
 * Algorithm: Greedy / Sort
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        Collections.sort(meetingList);

        System.out.println(getCountList(meetingList));
    }

    private static int getCountList(List<Meeting> meetingList) {
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
}

class Meeting implements Comparable<Meeting> {
    public final int startTime;
    public final int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.endTime != o.endTime) return this.endTime - o.endTime;
        return this.startTime - o.startTime;
    }
}