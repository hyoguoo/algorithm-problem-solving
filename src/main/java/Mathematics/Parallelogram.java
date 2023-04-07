/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1064
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Parallelogram {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Coordinate A = new Coordinate(input[0], input[1]);
        Coordinate B = new Coordinate(input[2], input[3]);
        Coordinate C = new Coordinate(input[4], input[5]);

        System.out.println(solution(A, B, C));
    }

    private static double solution(Coordinate A, Coordinate B, Coordinate C) {
        double answer;
        double a = Math.hypot(B.x - C.x, B.y - C.y);
        double b = Math.hypot(C.x - A.x, C.y - A.y);
        double c = Math.hypot(A.x - B.x, A.y - B.y);

        if ((B.x - A.x) * (C.y - A.y) == (C.x - A.x) * (B.y - A.y)) {
            answer = -1;
        } else {
            double ab = 2 * a + 2 * b;
            double bc = 2 * b + 2 * c;
            double ca = 2 * c + 2 * a;
            answer = Math.max(Math.max(ab, bc), ca) - Math.min(Math.min(ab, bc), ca);
        }
        return answer;
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
