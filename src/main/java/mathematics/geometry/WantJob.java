/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18221
 * Cheat Level: 0
 * Algorithm: Implementation / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WantJob {

    final static int NEED_STUDENT = 3;
    final static int STUDENT = 1;
    final static int ME = 2;
    final static int PROFESSOR = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Coordinate me = null;
        Coordinate professor = null;
        List<Coordinate> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length; j++) {
                if (input[j] == ME) me = new Coordinate(i, j);
                if (input[j] == PROFESSOR) professor = new Coordinate(i, j);
                if (input[j] == STUDENT) students.add(new Coordinate(i, j));
            }
        }

        System.out.println(solution(me, professor, students) ? 1 : 0);
    }

    private static boolean solution(Coordinate me, Coordinate professor, List<Coordinate> students) {
        if (getDistance(me, professor) < 25) return false;
        int minX = Math.min(me.x, professor.x);
        int maxX = Math.max(me.x, professor.x);
        int minY = Math.min(me.y, professor.y);
        int maxY = Math.max(me.y, professor.y);

        long count = students.stream()
                .filter(student ->
                        (student.x >= minX && student.x <= maxX)
                                && (student.y >= minY && student.y <= maxY)
                ).count();

        return count >= NEED_STUDENT;
    }

    private static double getDistance(Coordinate c1, Coordinate c2) {
        return Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
