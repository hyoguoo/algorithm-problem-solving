/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2775
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BecomeVicePresident {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            System.out.println(getPeopleCount(Integer.parseInt(bufferedReader.readLine()), Integer.parseInt(bufferedReader.readLine())));
        }
    }

    private static int getPeopleCount(int floor, int room) {
        int[][] peopleCountList = new int[floor + 1][room + 2];

        for (int i = 0; i <= floor; i++) {
            for (int j = 1; j <= room + 1; j++) calculateCount(peopleCountList, i, j);
        }

        return peopleCountList[floor][room];
    }

    private static void calculateCount(int[][] peopleCountList, int i, int j) {
        if (i == 0) peopleCountList[i][j] = j;
        else if (peopleCountList[i][j] != 0) return;
        else {
            int sum = 0;
            for (int x = 0; x <= j; x++) sum += peopleCountList[i - 1][x];
            peopleCountList[i][j] = sum;
        }
    }
}
