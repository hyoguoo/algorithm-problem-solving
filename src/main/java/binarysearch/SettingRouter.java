/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2110
 * Cheat Level: 3
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SettingRouter {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int houseCount = info[0];
        int routerCount = info[1];

        int[] houses = new int[houseCount];

        for (int i = 0; i < houseCount; i++) {
            houses[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(houses, routerCount));
    }

    private static int solution(int[] houses, int targetRouterCount) {
        Arrays.sort(houses);

        int left = 1;
        int right = houses[houses.length - 1] - houses[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = calculateRouterCount(houses, mid);

            if (count >= targetRouterCount) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static int calculateRouterCount(int[] houses, int routerRange) {
        int count = 1;
        int previousHousePosition = houses[0];

        for (int currentHousePosition : houses) {
            int distance = currentHousePosition - previousHousePosition;
            if (distance >= routerRange) {
                count++;
                previousHousePosition = currentHousePosition;
            }
        }

        return count;
    }
}
