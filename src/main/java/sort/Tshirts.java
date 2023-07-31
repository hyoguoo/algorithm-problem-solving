/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: -
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.util.Arrays;

public class Tshirts {

    public static void main(String[] args) {
        System.out.println(new Tshirts().solution(new int[]{2, 3}, new int[]{1, 2, 3}));
    }

    public int solution(int[] people, int[] tshirts) {
        Arrays.sort(people);
        Arrays.sort(tshirts);
        int answer = 0;

        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < tshirts.length; j++) {
                if (people[i] <= tshirts[j]) {
                    answer++;
                    tshirts[j] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
