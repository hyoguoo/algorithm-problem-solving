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
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfRooms {

    public static void main(String[] args) throws IOException {
        Meeting[] meetings = parseMeetings();

        System.out.print(solution(meetings));
    }

    private static int solution(Meeting[] meetings) {
        Arrays.sort(
                meetings,
                Comparator.comparingInt(o -> o.start)
        );
        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.end)
        );

        int count = 0;

        for (Meeting meeting : meetings) {
            deleteNonOverlappingMeeting(meeting, priorityQueue);

            priorityQueue.add(meeting);
            count = Math.max(count, priorityQueue.size());
        }

        return count;
    }

    private static void deleteNonOverlappingMeeting(
            Meeting meeting,
            PriorityQueue<Meeting> priorityQueue
    ) {
        while (!priorityQueue.isEmpty() &&
                priorityQueue.peek().end <= meeting.start) {
            priorityQueue.poll();
        }
    }


    private static Meeting[] parseMeetings() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int meetingCount = Integer.parseInt(bufferedReader.readLine());

        Meeting[] meetings = new Meeting[meetingCount];

        while (meetingCount-- > 0) {
            int[] meetingInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            meetings[meetingCount] = new Meeting(meetingInfo[0], meetingInfo[1]);
        }

        return meetings;
    }

    static class Meeting {

        private final int start;
        private final int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
