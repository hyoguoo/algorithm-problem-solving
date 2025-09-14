/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1598
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceNumbersFollowEachOther {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers[0], numbers[1]));
    }

    private static int solution(int a, int b) {
        return Coordinate.fromValue(a)
                .calculateDistance(Coordinate.fromValue(b));
    }

    static class Coordinate {

        private static final int COLUMNS_SIZE = 4;
        private final int row;
        private final int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public static Coordinate fromValue(int value) {
            int row = (value - 1) / COLUMNS_SIZE;
            int col = (value - 1) % COLUMNS_SIZE;
            return new Coordinate(row, col);
        }

        public int calculateDistance(Coordinate other) {
            return Math.abs(this.row - other.row) + Math.abs(this.col - other.col);
        }
    }
}
