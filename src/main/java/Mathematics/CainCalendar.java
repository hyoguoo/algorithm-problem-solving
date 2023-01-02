/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6064
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CainCalendar {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < length; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            System.out.println(solution(input));
        }
    }

    private static int solution(String[] input) {
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);
        int lcm = getLcm(m, n);

        for (int year = x; year <= lcm; year += m) {
            if (year % n == y || (year % n == 0 && y == n)) return year;
        }

        return -1;
    }

    private static int getLcm(int m, int n) {
        return m * n / getGcd(m, n);
    }

    private static int getGcd(int m, int n) {
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}
