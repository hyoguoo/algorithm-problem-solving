/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19598 / 11000
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumNumberOfRooms {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(initilizeMeetingList()));
    }

    private static List<Meeting> initilizeMeetingList() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Meeting> meetingList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] meetingInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetingList.add(new Meeting(meetingInfo[0], meetingInfo[1]));
        }
        return meetingList;
    }

    private static int solution(List<Meeting> meetingList) {
        meetingList.sort(Comparator.comparingInt(o -> o.start));
        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int count = 0;

        for (Meeting meeting : meetingList) {
            deleteNonOverlappingMeeting(meeting, priorityQueue);

            priorityQueue.add(meeting);
            count = Math.max(count, priorityQueue.size());
        }

        return count;
    }

    private static void deleteNonOverlappingMeeting(Meeting meeting, PriorityQueue<Meeting> priorityQueue) {
        while (!priorityQueue.isEmpty() &&
               priorityQueue.peek().end <= meeting.start) priorityQueue.poll();
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
