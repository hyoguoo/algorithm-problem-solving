/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14736
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CokeChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];
        int cokeCount = info[1];
        int cokePerSecond = info[2];

        Person[] people = new Person[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            int[] personInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            people[i] = new Person(personInfo[0], personInfo[1]);
        }

        System.out.print(solution(people, cokeCount, cokePerSecond));
    }

    private static int solution(Person[] people, int cokeCount, int cokePerSecond) {
        return Arrays.stream(people)
                .mapToInt(person -> person.calculateDrinkTime(cokeCount, cokePerSecond))
                .min()
                .orElseThrow();
    }

    static class Person {

        private final int drinkDuration;
        private final int restDuration;

        public Person(int drinkDuration, int restDuration) {
            this.drinkDuration = drinkDuration;
            this.restDuration = restDuration;
        }

        public int calculateDrinkTime(int cokeCount, int cokePerSecond) {
            int time = 0;
            int currentDrinkCoke = 0;

            while (true) {
                time += drinkDuration;
                currentDrinkCoke += cokePerSecond * drinkDuration;
                if (currentDrinkCoke >= cokeCount) {
                    int remainCoke = currentDrinkCoke - cokeCount;
                    time -= remainCoke / cokePerSecond;
                    break;
                }
                time += restDuration;
            }

            return time;
        }
    }
}
