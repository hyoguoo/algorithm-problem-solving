/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32025
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhysicalEducationIsMathSubject {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int widthMeter = Integer.parseInt(bufferedReader.readLine());
        int heightMeter = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(widthMeter, heightMeter));
    }

    private static int solution(int widthMeter, int heightMeter) {
        return Math.min(widthMeter, heightMeter) * 100 / 2;
    }
}
