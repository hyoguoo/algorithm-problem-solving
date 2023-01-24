/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19598
 * Cheat Level: 5
 * Algorithm: Greedy
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumNumberOfRooms {

    final static Queue<Meet> meetList = new PriorityQueue<>(Comparator.comparingInt(o -> o.endTime));
    final static List<Meet> meets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roomCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < roomCount; i++) {
            int[] timeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meets.add(new Meet(timeInfo[0], timeInfo[1]));
        }

        Collections.sort(meets);
        System.out.println(getMaxRoomCount());
    }

    private static int getMaxRoomCount() {
        int maxRoomCount = 0;
        for (Meet meet : meets) {
            while (!meetList.isEmpty() && meetList.peek().endTime <= meet.startTime) meetList.poll();
            meetList.add(meet);
            maxRoomCount = Math.max(maxRoomCount, meetList.size());
        }
        return maxRoomCount;
    }

}

class Meet implements Comparable<Meet> {
    public final int startTime;
    public final int endTime;

    public Meet(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meet o) {
        return this.startTime - o.startTime;
    }
}
