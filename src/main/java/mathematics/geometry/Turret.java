/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1002
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Turret {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < caseCount; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(numbers));
        }
    }

    private static int solution(int[] numbers) {
        int x1 = numbers[0];
        int y1 = numbers[1];
        int r1 = numbers[2];
        int x2 = numbers[3];
        int y2 = numbers[4];
        int r2 = numbers[5];

        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (d == 0 && r1 == r2) return -1;
        else if (d > Math.abs(r2 - r1) && d < r1 + r2) return 2;
        else if (Math.abs(r2 - r1) == d || r2 + r1 == d) return 1;
        else if (r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0) return 0;
        else return -1;
    }
}
