/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: -
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.util.Arrays;

public class NumberGame {

    public int solution(int[] A, int[] B) {
        descendingSort(A);
        descendingSort(B);

        int winCount = 0;
        int indexA = 0;
        int indexB = 0;

        while (true) {
            if (indexB >= B.length || indexA >= A.length) break;

            if (A[indexA] < B[indexB]) {
                winCount++;
                indexB++;
            }
            indexA++;
        }

        return winCount;
    }

    private void descendingSort(int[] arr) {
        Arrays.sort(arr);

        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }
    }
}
