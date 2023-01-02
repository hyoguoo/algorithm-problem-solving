/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10250
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMHotel {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < length; i++) {
            int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getRoomNumber(array[0], array[2]));
        }
    }

    private static int getRoomNumber(int floor, int order) {
        int roomNumber = order % floor;
        int floorNumber = order / floor + 1;
        if (roomNumber == 0) {
            roomNumber = floor;
            floorNumber--;
        }
        return roomNumber * 100 + floorNumber;
    }
}
