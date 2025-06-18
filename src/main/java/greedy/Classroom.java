/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31872
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Classroom {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int teleportCount = info[1];
        int[] classroomPositions = Arrays.stream(("0 " + bufferedReader.readLine()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(classroomPositions, teleportCount));
    }

    private static int solution(int[] classroomPositions, int teleportCount) {
        int[] sortedClassroomPositions = Arrays.stream(classroomPositions)
                .sorted()
                .toArray();

        return IntStream.rangeClosed(1, sortedClassroomPositions.length - 1)
                .map(i -> sortedClassroomPositions[i] - sortedClassroomPositions[i - 1])
                .sorted()
                .limit(sortedClassroomPositions.length - teleportCount - 1L)
                .sum();
    }
}
