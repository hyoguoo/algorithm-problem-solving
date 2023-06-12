/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 8980
 * Cheat Level: 3
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Courier {

    final static List<BoxInfo> BOX_INFO_LIST = new ArrayList<>();
    static int VILLAGE_COUNT, MAX_COUNT, BOX_COUNT;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static long solution() {
        long answer = 0;

        long[] villageBoxCount = new long[VILLAGE_COUNT + 1];
        Arrays.fill(villageBoxCount, MAX_COUNT);

        for (BoxInfo boxInfo : BOX_INFO_LIST) {
            int from = boxInfo.from;
            int to = boxInfo.to;
            int count = boxInfo.count;

            long capacity = Long.MAX_VALUE;

            for (int i = from; i < to; i++) {
                capacity = Math.min(capacity, villageBoxCount[i]);
            }

            for (int i = from; i < to; i++) {
                villageBoxCount[i] -= Math.min(capacity, count);
            }

            answer += Math.min(capacity, count);
        }

        return answer;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VILLAGE_COUNT = info[0];
        MAX_COUNT = info[1];
        BOX_COUNT = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < BOX_COUNT; i++) {
            int[] boxInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            BOX_INFO_LIST.add(new BoxInfo(boxInfo[0], boxInfo[1], boxInfo[2]));
        }

        BOX_INFO_LIST.sort((o1, o2) -> {
            if (o1.to == o2.to) return o1.from - o2.from;
            return o1.to - o2.to;
        });
    }

    static class BoxInfo {
        int from;
        int to;
        int count;

        public BoxInfo(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }
    }
}
