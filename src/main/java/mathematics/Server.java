/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10409
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int totalTime = info[1];
        int[] times = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(times, totalTime));
    }

    private static long solution(int[] times, int totalTime) {
        Acc acc = new Acc();

        return Arrays.stream(times)
                .map(acc::add)
                .takeWhile(ignored -> acc.within(totalTime))
                .count();
    }

    static class Acc {

        private int sum;

        public Acc() {
            this.sum = 0;
        }

        public int add(int value) {
            sum += value;
            return sum;
        }

        public boolean within(int limit) {
            return sum <= limit;
        }
    }
}
